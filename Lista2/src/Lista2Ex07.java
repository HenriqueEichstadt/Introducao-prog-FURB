import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex07 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        
        while(ehVazio(ABAIXO)) andarAbaixo();
        while(ehVazio(DIREITA)) andarDireita();
        while(ehVazio(ACIMA)) andarAcima();
        while(ehVazio(DIREITA)) andarDireita();
        while(ehVazio(ABAIXO)) andarAbaixo();
        while(ehVazio(ESQUERDA)) andarEsquerda();
        diga("cheguei no tesouro");
        
        
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex07.xml");
    }
    
}
