
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex10 extends Furbot {

    // método para a direção do robo
    private void andarRobo(Direcao direcao) {
        if (!ehFim(direcao)) {
            if (direcao == ABAIXO) {
                andarAbaixo();
            } else {
                andarAcima();
            }
        }
    }

    // método para o robô mudar de direção
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == ABAIXO) {
            direcao = ACIMA;
        } else {
            direcao = ABAIXO;
        }
        return direcao;
    }

    @Override
    public void inteligencia() throws Exception {
        Direcao direcao = ABAIXO;
        while (true) {
            andarRobo (direcao);
           if (ehFim(DIREITA) && ehFim(direcao)) {
                break;
            } else if (ehFim(direcao)) {
                // muda para a proxima coluna
                andarDireita();
                direcao = mudarDirecao(direcao);
            }
        }
        diga ("Cheguei ao final da direção");
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex10.xml");
    }
}
