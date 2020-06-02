
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/**
 *
 * @author Henrique Eichst
 */
public class Lista3Ex01 extends Furbot {

    int somaValores = 0;
    
    public void SomaValoresNaLinha(){
        if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){
            Numero numero = getObjeto(AQUIMESMO);
            somaValores += numero.getValor();
        }
    }
    
    @Override
    public void inteligencia() throws Exception {
     
        // Limpa console
        limparConsole();
        Direcao direcao = DIREITA;
        mudarPosicao(0, 0);

        while (true) {

            SomaValoresNaLinha();

            if (!ehFim(direcao)) {
                // andar para a direção
                if (direcao == DIREITA) {
                    andarDireita();
                } else {
                    andarEsquerda();
                }
                // Quando termina a direção
            } else {
                //dizer a soma
                diga("Soma da linha: " + getY() + " => " + somaValores);
                somaValores = 0;
                // Mudar a direção
                if (direcao == DIREITA) {
                    direcao = ESQUERDA;
                } else {
                    direcao = DIREITA;
                }
                // Ver se o robô pode descer
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                } else {
                    // para a repetição
                    break;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex01.xml");
    }
}
