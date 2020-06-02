package Unidade1.PreProva2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

public class Arquivo {

    private ArquivoTexto arquivoTexto;
    private ArquivoSerializado arquivoSerializado;
    private final String EXTENSAO_ARQUIVO = ".cli";
    private final String PASTA_NA_RAIZ_DO_PROJETO = ".\\Arquivos\\";

    public Arquivo() {
        arquivoTexto = new ArquivoTextoFactory();
        arquivoSerializado = new ArquivoSerializadoFactory();
    }

    public void salvar(String diretorio, String nome, Cliente cliente) {
        arquivoTexto.setDiretorio(PASTA_NA_RAIZ_DO_PROJETO + diretorio);
        Path dirArquivo = arquivoTexto.obterDiretorioComArquivo(nome + this.EXTENSAO_ARQUIVO);
        Path pathArquivo = arquivoTexto.getDiretorio();

        arquivoTexto.criarDiretorioEArquivo(pathArquivo, dirArquivo);

        try {
            BufferedWriter bw = arquivoTexto.escreverNoArquivo(dirArquivo, true);
            consistirCliente(bw, cliente);
            salvarObjetoSerializado(diretorio, cliente);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar arquivo " + ex.getMessage());
        }
    }

    public Cliente ler(String dietorio, String nome) {
        return this.lerLista(dietorio, nome).get(0);
    }

    public ArrayList<Cliente> lerLista(String diretorio, String nome) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        arquivoTexto.setDiretorio(PASTA_NA_RAIZ_DO_PROJETO + diretorio);
        Path dirArquivo = arquivoTexto.obterDiretorioComArquivo(nome + this.EXTENSAO_ARQUIVO);
        Path pathArquivo = arquivoTexto.getDiretorio();

        if (!arquivoTexto.arquivoExiste(dirArquivo)
                || !arquivoTexto.arquivoExiste(pathArquivo)) {
            throw new ArquivoOuDiretorioInexistenteException("O diretório ou o arquivo expecificado não exite");
        }

        try {
            BufferedReader br = arquivoTexto.lerArquivo(dirArquivo);

            if (!br.ready()) {
                throw new ArquivoVazioException("Não há nada a ser lido no arquivo");
            }
            ArrayList<String> linhasDoArquivo = new ArrayList<>();
            while (br.ready()) {
                linhasDoArquivo.add(removerTag(br.readLine()));
            }

            while (!linhasDoArquivo.isEmpty()) {

                // pegar nome do cliente
                String nomeCliente = linhasDoArquivo.remove(0);
                Cliente cliente = new Cliente(nomeCliente);

                // pegar doces
                while (!" ".equals(linhasDoArquivo.get(0)) && !linhasDoArquivo.get(0).contains(".")) {

                    int codigo = Integer.parseInt(linhasDoArquivo.remove(0));
                    String nomeDoce = linhasDoArquivo.remove(0);
                    float preco = Float.parseFloat(linhasDoArquivo.remove(0));

                    Doce doce = new Doce(codigo, nomeDoce, preco);
                    cliente.addDoce(doce);
                }
                clientes.add(cliente);
                // pegar precofinal
                linhasDoArquivo.remove(0);
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    public String listarArquivos(String diretorio) {
        File file = new File(PASTA_NA_RAIZ_DO_PROJETO + diretorio);
        String arquivos = "Arquivos no diretório: \n";
        for (File f : file.listFiles()) {
            arquivos += f.getName() + "\n";
        }
        return arquivos;
    }

    private String convertToTag(String srt) {
        return "<" + srt + ">";
    }

    private String removerTag(String srt) {
        srt = srt.replace("<", "");
        srt = srt.replace(">", "");
        return srt;
    }

    private void consistirCliente(BufferedWriter bw, Cliente cliente) throws IOException {

        bw.write(convertToTag(cliente.getNome()));

        for (Doce doce : cliente.getDocesComprados()) {
            String codigo = Integer.toString(doce.getCodigo());
            String preco = Float.toString(doce.getPreco());
            bw.newLine();
            bw.write(convertToTag(codigo));
            bw.newLine();
            bw.write(convertToTag(doce.getNome()));
            bw.newLine();
            bw.write(convertToTag(preco));
        }
        bw.newLine();
        String precoTotal = Float.toString(cliente.getTotalCompra());
        bw.write(convertToTag(precoTotal));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private void salvarObjetoSerializado(String diretorio, Cliente cliente) {
        arquivoSerializado.setDiretorio(PASTA_NA_RAIZ_DO_PROJETO + diretorio);
        Path dirArquivo = arquivoSerializado.obterDiretorioComArquivo(cliente.getNome() + ".ser");
        Path pathArquivo = arquivoSerializado.getDiretorio();

        arquivoSerializado.criarDiretorioEArquivo(pathArquivo, dirArquivo);

        try {
            ObjectOutputStream obj = arquivoSerializado.escreverNoArquivo(dirArquivo, true);
            for (Doce doce : cliente.getDocesComprados()) {
                
                obj.writeInt(doce.getCodigo());
                obj.writeUTF(doce.getNome());
                obj.writeFloat(doce.getPreco());
                obj.flush();
            }
            obj.close();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar arquivo " + ex.getMessage());
        }
    }
}
