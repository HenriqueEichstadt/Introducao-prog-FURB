
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex11 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (true) {
            if (ehObjetoDoMundoTipo("Alien", DIREITA)) {
                andarAbaixo();
                andarDireita();
                andarDireita();
                andarAcima();
            } else {
                andarDireita();
            }
    }

}
public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex11.xml");
    }
}
