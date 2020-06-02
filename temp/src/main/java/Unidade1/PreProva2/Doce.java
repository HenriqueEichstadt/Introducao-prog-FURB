package Unidade1.PreProva2;

public class Doce {
    private int codigo;
    private String nome;
    private float preco;

    public Doce(int codigo, String nome, float preco) throws Exception{
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setPreco(preco);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if(codigo > 0)
            this.codigo = codigo;
        else
            throw new IllegalArgumentException("Código inválido");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome inválido");
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) throws Exception {
        if(preco > 0)
            this.preco = preco;
        else
            throw new IllegalArgumentException("Preço inválido");
    }
}
