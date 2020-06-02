
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex06 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
  
            if (ehVazio(ABAIXO)) {
                andarAbaixo();
            }
            else {
                andarDireita();
            }
             if (ehVazio(ABAIXO)) {
                andarAbaixo();
            }
            else {
                andarDireita();
            }
         if (ehVazio(ABAIXO)) {
                andarAbaixo();
            }
            else {
                andarDireita();
            }
          if (ehVazio(ABAIXO)) {
                andarAbaixo();
            }
            else {
                andarDireita();
            }
           if (ehVazio(ABAIXO)) {
                andarAbaixo();
            }
            else {
                andarDireita();
            }
            if (ehFim(ABAIXO)) {
                andarDireita();
            }
            else {
                andarAbaixo();
            }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista1Ex06.xml");
    }

}
