
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex06 extends Furbot {

    @Override
    public void inteligencia() throws Exception {

        while (true) {

            if (ehVazio(DIREITA)) {
                andarDireita();
            } else {
                andarAbaixo();
            }
            if (ehFim(DIREITA)) {
                break;
            }
        }
    diga("Terminei");
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex06.xml");
    }

}
