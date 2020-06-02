package prova1;

/**
 *
 * @Aluno: Henrique Alexsander Eichstädt
 */
public class MatrizDeDoubles {

    private double[][] matriz;
    // Linhas da matriz
    private int m;
    // Colunas da Matriz
    private int n;

    public MatrizDeDoubles(int m, int n) {
        this.matriz = new double[m][n];
        this.m = m;
        this.n = n;
    }

    // Letra A
    public void setValor(int m, int n, double valor) {
        this.matriz[m][n] = valor;
    }

    // Letra B
    public double somaColuna(int coluna) {
        double resultado = 0;

        for (int linha = 0; linha < this.m; linha++) {
            resultado += this.matriz[linha][coluna];
        }
        return resultado;
    }

    // Letra C
    public int[] posicaoMenorValorPositivo() {
        int[] resultado = new int[2];
        double menorValorDaMatriz = Integer.MAX_VALUE;
        for (int linha = 0; linha < this.m; linha++) {
            for (int coluna = 0; coluna < this.n; coluna++) {
                if (this.matriz[linha][coluna] >= 0 && this.matriz[linha][coluna] < menorValorDaMatriz) {
                    menorValorDaMatriz = this.matriz[linha][coluna];
                    resultado[0] = linha;
                    resultado[1] = coluna;
                }
            }
        }
        return resultado;
    }

    // Letra D
    public MatrizDeDoubles transposta() {
        MatrizDeDoubles novaMatrizDeDoubles = new MatrizDeDoubles(this.n, this.m);
        for (int linha = 0; linha < this.m; linha++) {
            for (int coluna = 0; coluna < this.n; coluna++) {
                novaMatrizDeDoubles.matriz[coluna][linha] = this.matriz[linha][coluna];
            }
        }
        return novaMatrizDeDoubles;
    }
}
