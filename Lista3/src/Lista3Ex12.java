
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author Henrique Eichst
 */
public class Lista3Ex12 extends Furbot {

    // método para fazer o robo andar
    public void andar() {
        while (!ehFim(DIREITA)) {
            andarDireita();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }
    }

    // andar ao topo
    public void AndarTopo() {
        if (!ehFim(ACIMA)) {
            andarAcima();
        } else {
            andarEsquerda();
        }
    }

    @Override
    public void inteligencia() throws Exception {
        // limpa o console
        limparConsole();
        // Muda a posição do robô
        mudarPosicao(0, 0);

        while (true) {
            // pegar o numero onde está
            Numero numero1 = getObjeto(AQUIMESMO);
            // andar a direita
            andarDireita();
            // pegar o novo numero
            Numero numero2 = getObjeto(AQUIMESMO);
            // andar a direita
            andarDireita();
            // fazer a conta
            int resultado = numero1.getValor() - numero2.getValor();
            // criar um objeto
            Numero total = new Numero();
            // passar o resultado para o objeto
            total.setValor(resultado);
            // colocar o objeto no mapa
            adicionarObjetoNoMundo(total, AQUIMESMO);
            // verificar se terminou o mapa
            if (!ehFim(ABAIXO)) {
                andarEsquerda();
                andarEsquerda();
                andarAbaixo();
            } else {
                removerMe();
                break;
            }
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex12.xml");
    }
}
