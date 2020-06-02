package Unidade1.PreProva2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ArquivoTextoFactory extends ArquivoBase<BufferedReader, BufferedWriter>
        implements ArquivoTexto {

    @Override
    public BufferedReader lerArquivo(Path dirArquivo) {
        try {
            FileReader fr = new FileReader(dirArquivo.toFile());
            return new BufferedReader(fr);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao ler arquivo. " + ex.getMessage());
        }
    }

    @Override
    public BufferedWriter escreverNoArquivo(Path dirArquivo, boolean agregar) {
        try {
            FileWriter fw = new FileWriter(dirArquivo.toFile(), agregar);
            return new BufferedWriter(fw);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao escrever no arquivo. " + ex.getMessage());
        }
    }
}
