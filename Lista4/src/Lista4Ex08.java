
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista4Ex08 extends Furbot {

    // Atributo para pegar o numero do mapa
    private int numeroGuardado = 0;

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

    private void PegaNumeroNaPosicao(int numero) {
        // pega o numero na posição
        numeroGuardado = numero;
    }

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
            // se encontrar Alien
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                PegaNumeroNaPosicao(numero.getValor());
            }
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                if (numeroGuardado == 0) {
                    diga("Não tenho um número para fazer o cálculo");
                } else {
                    int metadeDoNumeroGUardado = numeroGuardado / 2;
                    diga("Números primos de " + metadeDoNumeroGUardado + " até " + numeroGuardado);
                    for (int count = metadeDoNumeroGUardado; count <= numeroGuardado; count++) {
                        if (ehPrimo(count)) {
                            diga(count);
                        }
                    }
                }
                numeroGuardado = 0;
            }
            if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                if (numeroGuardado == 0) {
                    diga("Não tenho um número para fazer o cálculo");
                } else {
                    int dobroDoNumeroGuardado = numeroGuardado * 2;
                    diga(" Números impares de " + numeroGuardado + "  até " + dobroDoNumeroGuardado);
                    for (int count = numeroGuardado; count <= dobroDoNumeroGuardado; count++) {
                        if (count % 3 == 1) {
                            diga(count);
                        }
                    }
                }
                numeroGuardado = 0;
            }
            if (!ehFim(direcao)) {
                //andar para a direção
                andar(direcao);
                //quando termina a direção
            } else {
                //mudar a direção
                direcao = mudarDirecao(direcao);
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
        MundoVisual.iniciar("Lista4Ex08.xml");
    }

}
