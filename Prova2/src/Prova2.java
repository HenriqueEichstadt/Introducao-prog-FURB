
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import br.furb.furbot.Tesouro;

/**
 *
 * @author Henrique Alexsander Eichstädt Prova 2 Data: 05/11/2018
 */
public class Prova2 extends Furbot {
    // variavel para a direção do robo

    Direcao direcao = ABAIXO;
    // Variavel para pegar o maior tesouro do mapa
    public int maiorTesouroDoMapa = 0;
    // Variável para a linha do maior tesouro
    public int linhaDoMaiorTesouro = 0;
    // Variável para a coluna do maior Tesouro
    public int colunaDoMaiorTesouro = 0;
    // variável para contar a quantidade de booleanos true inseridas no mapa
    public int countQtdTrue = 0;
    // variável para contar a quantidade de booleanos true inseridas no mapa
    public int countQtdfalse = 0;


    /*
        Método para ir até o final do Mundo
     */
    public void AndarTeFinalDoMundo() {
        int linha = getQtdeLinhas() - 1;
        int coluna = getQtdeColunas() - 1;
        mudarPosicao(coluna, linha);
        direcao = DIREITA;
        if (ehFim(DIREITA)) {
            return;
        }
    }

    /*
        Método para Adicionar Booleano na posição
        (usado quando encontrar o número 2)
     */
    public void AdicionaBooleanoAqui(boolean valor) {
        Booleano bool = new Booleano();
        bool.setValor(valor);
        adicionarObjetoNoMundo(bool, AQUIMESMO);
    }

    /*
        Método para avançar duas casas na direção
        em que o robô entá andando
     */
    public void AndarDuasCasas(Direcao direcao) {
        // Variáveis para pegar a quantidade de linhas e colunas
        // pegar quantidade de linhas
        int casaUm = getY();
        //pegar quantidade de linhas
        int qtdLinhas = getQtdeLinhas();
        // Se for Penultima Casa da coluna
        if (casaUm == 1 || qtdLinhas == getQtdeLinhas() -1) {
            andar(direcao);
        }
        if (getQtdeLinhas() == qtdLinhas) {
            return;
        } else {
            andar(direcao);
            andar(direcao);
        }

    }

    /* Método para verificar se existe Tesouro na Posição e 
       pegar seu valor caso seja o maior encontado até o momento
     */
    public void VerificatesouroNaPosicao() {
        // vê se tem tesouro na posição
        if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
            // pega o tesouro
            Tesouro tesouro = getObjeto(AQUIMESMO);
            // pega o valor do tesouro
            int valorTesouro = tesouro.getValor();
            // Se o Valor For o maior encontrado até o momento
            if (valorTesouro > maiorTesouroDoMapa) {
                maiorTesouroDoMapa = valorTesouro;
                // pega a linha e atribui ao atributo para guardar o valor
                linhaDoMaiorTesouro = tesouro.getY();
                //pega a coluna
                colunaDoMaiorTesouro = tesouro.getX();
                // Adiciona um booleano true no lugar do numero
            }
        }
    }

    /* Método para verificar se existe número na posição
       e atuar sobre o valor na posição
     */
    public void VerificaNumeroNaPosicao() {
        // Se tem numero na posição
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            // pega objeto
            Numero numero = getObjeto(AQUIMESMO);
            // pega valor
            int valorNumero = numero.getValor();
            // switch para testar valor
            switch (valorNumero) {
                case 1:
                    numero.removerMe();   // Remove o numero na posição
                    mudarPosicao(0, 0);   // volta para a posição inicial
                    direcao = ABAIXO;
                    andar(direcao);       // começa a andar na direção denovo
                    break;
                case 2:
                    AdicionaBooleanoAqui(true);  // adiciona booleano true na posição
                    countQtdTrue++;              // soma boolenao no contador
                    break;
                case 3:
                    AdicionaBooleanoAqui(false); // adiciona booleano false na posição
                    countQtdfalse++;             // soma booleano no contador
                    break;
                case 4:
                    AndarDuasCasas(direcao);     // anda duas casas sem testar
                    break;
                case 5:
                    AndarTeFinalDoMundo();      // anda até o final do mundo
                    break;
            }
        }
    }
    //método para a direção do Robô

    private void andar(Direcao direcao) {
        if (!ehFim(direcao)) {
            if (direcao == ABAIXO) {
                andarAbaixo();
            } else {
                andarAcima();
            }
        }
    }

    //método para mudar a direção do Robô
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == ABAIXO) {
            direcao = ACIMA;
        } else {
            direcao = ABAIXO;
        }
        return direcao;
    }

    @Override
    public void inteligencia() throws Exception {

        // limpa o console
        limparConsole();
        //criar looping infinito
        while (true) {
            // Executa os métodos criados para Tesouros e Numeros
            VerificaNumeroNaPosicao();
            VerificatesouroNaPosicao();
            // anda na direção
            andar(direcao);
            //verifica se é fim do mapa
            if (ehFim(DIREITA) && ehFim(direcao)) {
                break;
                // caso contrário
            } else if (ehFim(direcao)) {
                // Executa os métodos criados para Tesouros e Numeros
                VerificaNumeroNaPosicao();
                VerificatesouroNaPosicao();
                // muda a direção
                direcao = mudarDirecao(direcao);
                //desce para a próxima linha
                andarDireita();
            }
        }
        // faz o robô falar
        diga("Missão Cumprida!");
        if (maiorTesouroDoMapa < 1) {
            diga("Não achei tesouro!");
        } else {
            diga("O valor do maior tesouro encontrado foi de: " + maiorTesouroDoMapa);
            diga("A linha do maior tesouro encontrado: " + linhaDoMaiorTesouro);
            diga("A coluna do maior tesouro encontrado: " + colunaDoMaiorTesouro);
        }
        // faz o robô falar a quantidade de booleanos TRUE inseridas pelo mapa
        diga("A quantidade de booleanos TRUE inseridas no mapa: " + countQtdTrue);
        // faz o robô falar a quantidade de booleanos FALSE inseridas pelo mapa
        diga("A quantidade de booleanos TRUE inseridas no mapa: " + countQtdTrue);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Prova2.xml");
    }
}
