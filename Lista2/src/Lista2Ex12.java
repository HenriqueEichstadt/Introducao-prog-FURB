
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique
 */
public class Lista2Ex12 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Variavel para a direção do robô

        // Cria um loop infinito
        while (true) {
            // Verifica a direção para orobo andar
            if (ehVazio(DIREITA)) {
                andarDireita();
            } else {
                andarAbaixo();
                if (ehVazio(ACIMA)) {
                    andarAcima();
                } else {
                    andarDireita();
                }
            }
            // Verificar se é fim do mapa

        }

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex12.xml");

    }
}
