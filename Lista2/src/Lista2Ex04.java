
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
public class Lista2Ex04 extends Furbot{

    @Override
    public void inteligencia() throws Exception {
        
        while(!ehFim(DIREITA)) andarDireita();
        diga("Cheguei a direita na parte superior do mapa");
        while(!ehFim(ABAIXO)) andarAbaixo();
        diga("Cheguei a direita na parte inferior do mapa");
        while(!ehFim(ESQUERDA)) andarEsquerda();
        diga("Cheguei a esquerda na parte inferior do mapa");
        while(!ehFim(ACIMA)) andarAcima();
        diga("Cheguei a esquerda na parte superior do mapa");
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex04.xml");
    }
}
