
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex09 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Limpa console
        limparConsole();
        // Variável para direção
        Direcao direcao = DIREITA;
        while (true) {

            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
            }
           if(ehFim(direcao)){
               // Mudar a direção
               if(direcao == DIREITA){
                   direcao = ESQUERDA;
               }else{
                   direcao = DIREITA;
               }
               // Ver se o robô pode descer
               if(!ehFim(ABAIXO)){
                   andarAbaixo();
               }else{
                   // para a repetição
                   break;
               }
           }
        }
        diga("Cheguei");
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex09.xml");
    }
}
