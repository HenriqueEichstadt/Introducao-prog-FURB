
import br.furb.furbot.Alien;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Tesouro;

/**
 *
 * @author Henrique Eichst
 */
public class Prova1 extends Furbot {

    // atributo para contar o total de moedas 
    public int totalDeMoedas = 0;
    // atributo para pegar o valor do ultimo tesouro
    public int ultimoTesouro = 0;
    // atributo para somar o total de moedas que o robô perdeu
    public int moedasQuePerdeu = 0;
    // atributo Booleano para ver se o robô está vivo
    public boolean Morri = false;

    // método para pegar o objeto pelo mapa e calcular de acordo com a regra
    public void PegaObjetoPeloCaminhoECalcula() {
        // Se encontrar um tesouro pelo caminho
        if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
            // pega o objeto (tesouro)
            Tesouro tesouro = getObjeto(AQUIMESMO);
            // pega o valor do tesouro
            totalDeMoedas += tesouro.getValor();
            // soma o total de moedas para colocar na "MOCHILA"
            ultimoTesouro = tesouro.getValor();
        }
        // Se encontrar um Alien pelo caminho
        if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
            // Pega o objeto (Alien)
            Alien alien = getObjeto(AQUIMESMO);
            // Se for coluna Impar
            if (alien.getX() % 2 == 1) {
                // Ultimo tesouro vale o dobro
                ultimoTesouro = ultimoTesouro * 2;
                // soma o ultimo tesouro e coloca na "Mochila"
                totalDeMoedas += ultimoTesouro;
                // se for coluna par
            } else if (alien.getY() % 2 == 0) {
                if (totalDeMoedas == 0) {
                    Morri = true;
                    if (Morri == true) {
                        diga("Fui morto pelo inimigo !");
                    }
                } else {
                    // perde metade das moedas
                    int perdeuMetade = totalDeMoedas / 2;
                    // Total de moeda recebe metade de seu valor
                    totalDeMoedas = perdeuMetade;
                    // Soma para ver quantas moedas perdeu
                    moedasQuePerdeu += perdeuMetade;
                }
            }
        }
    }

    @Override
    public void inteligencia() throws Exception {

        limparConsole();

        while (true) {
            while (!ehFim(DIREITA)) {
                PegaObjetoPeloCaminhoECalcula();
                andarDireita();
                PegaObjetoPeloCaminhoECalcula();
                andarAbaixo();
            }
            while (!ehFim(ABAIXO)) {
                PegaObjetoPeloCaminhoECalcula();
                andarAbaixo();
                PegaObjetoPeloCaminhoECalcula();
                andarEsquerda();
            }
            if (ehFim(ESQUERDA)) {
                PegaObjetoPeloCaminhoECalcula();

                // faz o robô falar
                diga("Consegui chegar ao Fim!!");
                diga("Cheguei com:  " + totalDeMoedas + " Moedas");
                diga("Perdi: " + moedasQuePerdeu + " Moedas");
                if (totalDeMoedas > moedasQuePerdeu) {
                    diga("Estou Feliz!");
                } else if (moedasQuePerdeu > totalDeMoedas) {
                    diga("Estou Triste!");
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Prova1.xml");
    }
}
