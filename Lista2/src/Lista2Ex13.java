
import br.furb.furbot.Alien;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex13 extends Furbot {

    @Override
    public void inteligencia() throws Exception {

        int soma = 0;

        while (!ehFim(DIREITA)) {
            andarDireita();
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                soma++;
            }
        }
        if (soma == 0) {
            diga("Nenhum Alien na linha");
        }
        if (soma > 1) {
            diga("Quantidade de Aliens: " + soma);
        }
        if(soma == 1){
            diga("Apenas um Alien na linha");
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex13.xml");
    }
}
