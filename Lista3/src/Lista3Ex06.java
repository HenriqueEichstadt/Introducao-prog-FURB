
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista3Ex06 extends Furbot {

    public void andarTopo() {
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }
    }

    private void andar(Direcao direcao) {
        switch (direcao) {
            case DIREITA:
                andarDireita();
                break;
            case ESQUERDA:
                andarDireita();
                break;
            case ACIMA:
                andarAcima();
                break;
            case ABAIXO:
                andarAbaixo();
                break;
        } 
    }

    public double andarBorda(Direcao direcao) {
        // definir variavel para a soma
        double soma = 0;
        // variavel para contar os numeros
        int qtdDeNumeros = 0;

        while (!ehFim(direcao)) {
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // Pega o numero
                Numero numero = getObjeto(AQUIMESMO);
                // soma o valor
                soma += numero.getValor();
                // contar o numero na posicao
                qtdDeNumeros++;
            }
            andar(direcao);
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // Pega o numero
                Numero numero = getObjeto(AQUIMESMO);
                // soma o valor
                soma += numero.getValor();
                // contar o numero na posicao
                qtdDeNumeros++;
            }
        }
        diga("Soma = " + soma);
        // retornar a média
        return soma / qtdDeNumeros;
    }

    @Override
    public void inteligencia() throws Exception {
        //Faz o robo andar até o topo
        andarTopo();
        // fala a média da linha superior
        diga("Média superior =" + andarBorda(DIREITA));
        // Diga a média da coluna direita
        diga("Média direita =" + andarBorda(ABAIXO));
        // Fala a média na linha inferior
        diga("Média inferior =" + andarBorda(ESQUERDA));
        // Fala a média na Coluna Direita
        diga("Média superior =" + andarBorda(ACIMA));

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex06.xml");
    }
}
