
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex05 extends Furbot {

    @Override
    public void inteligencia() throws Exception {

        
        andarDireita();
        andarDireita();
        andarDireita();
        andarAbaixo();

        andarEsquerda();
        andarEsquerda();
        andarEsquerda();
        andarAbaixo();

        andarDireita();
        andarDireita();
        andarDireita();
        andarAbaixo();

        andarEsquerda();
        andarEsquerda();
        andarEsquerda();

        diga("Cheguei ao Final");
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista1Ex05.xml");
    }

}
