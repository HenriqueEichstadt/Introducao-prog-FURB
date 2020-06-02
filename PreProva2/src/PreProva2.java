
import br.furb.furbot.Alien;
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.Tesouro;

/**
 *
 * Aluno: Henrique Eichstädt Pré Prova 2 29/10/2018
 *
 */
public class PreProva2 extends Furbot {

    // atributo para pegar o valor do maior número encontrado no mapa
    public int maiorNumeroDoMapa = 0;
    // atributo para pegar valor da linha do maior Número
    public int linhaDoMaiorNumero = 0;
    // atributo para pegar o valor da coluna do maior Número
    public int colunaMaiorNumero = 0;
    //variavel para a direção do robo
    Direcao direcao = DIREITA;

    //método para a direção do Robô
    private void andar(Direcao direcao) {
        if (!ehFim(direcao)) {
            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
            }
        }
    }

    //método para mudar a direção do Robô
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            direcao = DIREITA;
        }
        return direcao;
    }

    // método para ver o objeto do mapa
    public void VerificaEExecutaAcaoSobreNumeroNoMapa() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            // pega o valor do número 
            Numero numero = getObjeto(AQUIMESMO);
            int valorDoNumero = numero.getValor();
            // ver se o número é o maior encontrado até o momento
            if (valorDoNumero > maiorNumeroDoMapa) {
                // recebe o valor do número na posição
                maiorNumeroDoMapa = valorDoNumero;
                // pega a linha e atribui ao atributo para guardar o valor
                linhaDoMaiorNumero = numero.getY();
                //pega a coluna
                colunaMaiorNumero = numero.getX();
                // Adiciona um booleano true no lugar do numero
                Booleano booleano = new Booleano();
                booleano.setValor(true);
                adicionarObjetoNoMundo(booleano, AQUIMESMO);
            }
        }
    }

    public void VerificaSetemAlienNaDirecao(Direcao direcao) {
        // Verifica se tem Alien na posição
        if (ehObjetoDoMundoTipo("Alien", direcao)) {
            // pega o alien
            Alien alien = getObjeto(direcao);
            // se for a primeira linha do mapa ou não for vazio acima
            if (alien.getY() == 0 || alien.ehVazio(ACIMA) == false) {
                // diz que não pode continuar e encerra o percurso
                diga("Não consigo passar pelo Alien!");
            } // caso contrário
            else {
                if (alien.ehVazio(ACIMA)) {
                    // pega o alien e faz andar uma vez acima
                    alien.andarAcima();
                }
            }
        }
    }

    // Método para ver se tem tesouro na posição e executar ação
    public void VerificaSeTemTesouroAqui() {
        // vê se tem tesouro na posição
        if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
            // pega o tesouro
            Tesouro tesouro = getObjeto(AQUIMESMO);
            // pega o valor do tesouro
            int valorTesouro = tesouro.getValor();
            switch (valorTesouro) {
                // se o tesouro vale 1
                case 1:
                    // se tiver na ultima linha
                    if (ehFim(ABAIXO)) {
                        diga("Não consigo chegar ao fim!");
                    } else {
                        // anda abaixo e mantém a direção
                        andarAbaixo();
                        break;
                    }
                // se o tesouro vale 2
                case 2:
                    // se tiver na ultima linha
                    if (ehFim(ABAIXO)) {
                        diga("Não consigo chegar ao fim!");
                    } else {
                        // anda abaixo e muda de direção
                        andarAbaixo();
                        direcao = mudarDirecao(direcao);
                        break;
                    }
                // se o tesouro vale 3 ou 4
                case 3:
                case 4:
                    // continua na direção
                    andar(direcao);
                    break;
                // se o tesouro vale 5
                case 5:
                    // diz que está cansado e para a execução
                    diga("Estou Cansado!");
                    break;
            }
        }
    }

    @Override
    public void inteligencia() throws Exception {
        // limpa o console
        limparConsole();
        //criar looping infinito
        while (true) {
            // Executa os métodos
            VerificaEExecutaAcaoSobreNumeroNoMapa();
            VerificaSetemAlienNaDirecao(direcao);
            VerificaSeTemTesouroAqui();
            // anda na direção
            andar(direcao);
            //verifica se é fim do mapa
            if (ehFim(ABAIXO) && ehFim(direcao)) {
                break;
                // caso contrário
            } else if (ehFim(direcao)) {
                // muda a direção
                direcao = mudarDirecao(direcao);
                //desce para a próxima linha
                VerificaEExecutaAcaoSobreNumeroNoMapa();
                VerificaSetemAlienNaDirecao(direcao);
                VerificaSeTemTesouroAqui();
                andarAbaixo();
            }
        }
        // faz o robô falar
        diga("Missão Cumprida!");
        diga("O Maior Número encontrado foi: " + maiorNumeroDoMapa);
        diga("Linha do maior número: " + linhaDoMaiorNumero);
        diga("Coluna do maior Número: " + colunaMaiorNumero);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("PreProva2.xml");
    }
}
