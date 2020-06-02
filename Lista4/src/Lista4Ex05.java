import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista4Ex05 extends Furbot {

    /**
     * método para o robô andar em uma determinada direção
     */
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

    /**
     * método para o robô mudar de direção
     */
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            if (direcao == ESQUERDA) {
                direcao = DIREITA;
            } else {
                if (direcao == ACIMA) {
                    direcao = ABAIXO;
                } else {
                    if (direcao == ABAIXO) {
                        direcao = ACIMA;
                    }
                }
            }
        }
        return direcao;
    }
    
    private String NumerosPrimosAbaixo(int numero) {
        //inicializar texto para resultado
        String textoPrimo = "Primos abaixo do " + numero + "\n";
        //para todos os antecessores do número
        for (int cont = 1; cont < numero; cont++) {
            //testar se é primo
            if (ehPrimo(cont)) {
                textoPrimo += cont + " ";
            }
        }
        return textoPrimo;
    }

    /**
     * retorna se é primo
     *
     * @throws Exception
     */
    private boolean ehPrimo(int numero) {
        //dividir o número pelo seus  antecessores até a sua metade
        for (int cont = 2; cont <= numero / 2; cont++) {
            //verificar o resto da divisão
            if (numero % cont == 0) {
                //número não é primo
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void inteligencia() throws Exception {
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {
            //se tem número
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                System.out.println(NumerosPrimosAbaixo(numero.getValor()));
            }
            if (!ehFim(direcao)) {
                //andar para a direção
                andar(direcao);
                //quando termina a direção
            } else {
                //mudar a direção
                direcao = mudarDirecao (direcao);
                //ver se o robô pode descer
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                } else {
                    //para a repetição
                    break;
                }
            }
        }
        diga("Cheguei!");

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex05.xml");
    }

}
