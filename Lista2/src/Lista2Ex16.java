
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
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
public class Lista2Ex16 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Limpa console
        limparConsole();
        Direcao direcao = DIREITA;
        int soma = 0;
        int maiorValor = 0;
        mudarPosicao(0, 0);

        while (true) {

            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                soma += numero.getValor();

            }

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
                diga("Soma da linha: " + getY() + " => " + soma);
                if(maiorValor < soma){
                    maiorValor = soma;
                }
                soma = 0;
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
         diga("A lida de maior Soma:  " + maiorValor);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex16.xml");
    }
}
