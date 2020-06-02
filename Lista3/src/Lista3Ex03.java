
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/**
 *
 * @author Henrique Eichst
 */
public class Lista3Ex03 extends Furbot {

    private void andar(Direcao direcao) {
        if (direcao == DIREITA) {
            andarDireita();
        } else {
            if (direcao == ESQUERDA) {
                andarEsquerda();
            } else {
                if (direcao == ACIMA) {
                    andarAcima();
                } else {
                    if (direcao == ABAIXO) {
                        andarAbaixo();
                    }
                }
            }
        }
    }

    // método para verificar se tem alien, numero ou booleano na posição do robô
    public int VerificarObjeto() {
        int passos = 0;
        // se tem alien
        if (ehObjetoDoMundoTipo("ALien", AQUIMESMO)) {
            // deslocar alien para a esquerda
            passos = deslocarObjeto(getObjeto(AQUIMESMO), ESQUERDA);
        } else {
            // se é numero
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // deslocar o numero para a direita
                passos = deslocarObjeto(getObjeto(AQUIMESMO), DIREITA);
            } else {
                // se é booleano
                if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                    // deslocar objeto acima
                    passos = deslocarObjeto(getObjeto(AQUIMESMO), ACIMA);
                }
            }
        }
        return passos;
    }
    
    // Método para deslocar objeto até a extremidade da direção
    public int deslocarObjeto( ObjetoDoMundo obj ,Direcao direcao) {
        int passos = 0;
        // Pega objeto, serve para qualquer objeto

        while (!obj.ehFim(direcao)) {
            switch (direcao) {
                case DIREITA:
                    obj.andarDireita();
                    break;
                case ESQUERDA:
                    obj.andarEsquerda();
                    break;
                case ACIMA:
                    obj.andarAcima();
                    break;
                case ABAIXO:
                    obj.andarAbaixo();
                    break;
            }
            passos++;
        }
        return passos;
    }

    @Override
    public void inteligencia() throws Exception {

        // Limpa console
        limparConsole();
        // Variável para direção
        Direcao direcao = DIREITA;
        // Variavel para total de passos
        int passos = 0;
        while (true) {
            // verificar se tem alien, numero e booleano e contar os passos
            passos += VerificarObjeto();
            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
            }
            if (ehFim(direcao)) {
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
        diga("Andei um total de " + passos + " passos");

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex03.xml");
    }
}
