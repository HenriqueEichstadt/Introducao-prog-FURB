
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
public class Lista2Ex05 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Ir até o fim da direita
        while (getY() != getQtdeLinhas() - 1) {

            while (!ehFim(DIREITA)) {
                andarDireita();
            }
            andarAbaixo();
            // Ir até o fim da esquerda
            while (!ehFim(ESQUERDA)) {
                andarEsquerda();
            }
            // Se não é fim do mapa
            if (!ehFim(ABAIXO)) {
                //descer
                andarAbaixo();
            }
        }
        diga("Cheguei !!!");
    }
    

    

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex05.xml");
    }
}
