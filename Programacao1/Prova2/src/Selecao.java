
import java.util.ArrayList;

/**
 *
 * @author Henrique Alexsander Eichstädt
 */
public class Selecao {

    private String pais;
    private String treinador;
    private int ranking;
    private ArrayList<Jogador> jogadores = new ArrayList(23);

    public Selecao(String pais, String treinador, int ranking) {
        this.setPais(pais);
        this.setTreinador(treinador);
        this.setRanking(ranking);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        if (!pais.isEmpty()) {
            this.pais = pais;
        } else {
            throw new IllegalArgumentException("País inválido");
        }
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        if (!treinador.isEmpty()) {
            this.treinador = treinador;
        } else {
            throw new IllegalArgumentException("Treinador inválido");
        }
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        if (ranking > 0) {
            this.ranking = ranking;
        } else {
            throw new IllegalArgumentException("Ranking inválido");
        }
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        if (jogadores != null && this.jogadores.size() <= 23) {
            this.jogadores = jogadores;
        } else {
            throw new IllegalArgumentException("Jogador inválido");
        }
    }
    
    public void addJogador(Jogador jogador){
        if(this.jogadores.size() <= 23){
        this.jogadores.add(jogador);
        } else{
            throw new IllegalArgumentException("Jogador inválido");
        }
    }

    public int getIdadeMedia() {
        return this.getIdadeTotalDosJogadores() / this.jogadores.size();
    }

    public int getQuantosAbaixoMediaAltura() {
        double alturaMedia = this.getAlturaMediaDosJogadores();
        int total = 0;
        for (Jogador jog : this.jogadores) {
            if (jog.getAltura()< alturaMedia) {
                total++;
            }
        }
        return total;
    }

    public Jogador getJogadorMaisVelho() {
        Jogador maisVelho = new Jogador();
        int maiorIdade = 0;
        for (Jogador jog : this.jogadores) {
            if (jog.getIdade() > maiorIdade) {
                maiorIdade = jog.getIdade();
                maisVelho = jog;
            }
        }
        return maisVelho;
    }

    public Jogador getJogadores(String posicao) {
        Jogador jogador = new Jogador();
        for (Jogador jog : this.jogadores) {
            if (jog.getPosicao().equals(posicao)) {
                jogador = jog;
            }
        }
        return jogador;
    }

    private int getIdadeTotalDosJogadores() {
        int total = 0;
        for (Jogador j : this.jogadores) {
            total += j.getIdade();
        }
        return total;
    }
    
    private double getAlturaMediaDosJogadores(){
        double total = 0;
        for (Jogador j : this.jogadores) {
            total += j.getAltura();
        }
        return total / this.jogadores.size();
    }
}
