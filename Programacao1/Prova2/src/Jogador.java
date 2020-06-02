
/**
 *
 * @author Henrique Alexsander Eichstädt
 */
public class Jogador {

    private String nome;
    private String posicao;
    private double altura;
    private int idade;

    public Jogador(String nome, String posicao, double altura, int idade) {
        this.setNome(nome);
        this.setPosicao(posicao);
        this.setAltura(altura);
        this.setIdade(idade);
    }

    public Jogador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome Inválido");
        }
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        if (!posicao.isEmpty()) {
            this.posicao = posicao;
        } else {
            throw new IllegalArgumentException("Posição inválida");
        }

    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            throw new IllegalArgumentException("Altura inválida");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade inválida");
        }
    }
}
