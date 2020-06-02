package prova1;


/**
 *
 * @Aluno: Henrique Alexsander Eichstädt
 * Questão 2
 */
public class Empresa {

    private String nome;

    private int anoDeFundacao;

    private double[] faturamentoAnual = new double[10];

    private char ramoDeAtuacao;

    
    // Letra A
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeFundacao() {
        return this.anoDeFundacao;
    }

    public void setAnoDeFundacao(int anoDeFundacao) {
        this.anoDeFundacao = anoDeFundacao;
    }

    public double[] getFaturamentoAnual() {
        return this.faturamentoAnual;
    }

    public void setFaturamentoAnual(int ano, double valorDoFaturamento) {
        if(ano <= this.faturamentoAnual.length){
            this.faturamentoAnual[ano] = valorDoFaturamento;
        }
    }

    public char getRamoDeAtuacao() {
        return this.ramoDeAtuacao;
    }

    public void setRamoDeAtuacao(char ramo) {
        if (ramo == 'S' || ramo == 'I' || ramo == 'C') {
            this.ramoDeAtuacao = ramo;
        }
    }

    // Letra B
    public double faturamentoMedioUltimosCincoAnos() {
        double resultado = 0;
        for (int i = 0; i < 5; i++) {
            resultado += this.faturamentoAnual[i];
        }
        if (this.faturamentoAnual.length <= 5) {
            return (resultado / this.faturamentoAnual.length);
        }
        else{
            return (resultado / 5);
        }
    }
    
    // Letra C
    public double faturamentoPrevistoParaOProximoAno(){
        double fatPrev = 0;
        double fatPrimeiroAno = this.faturamentoAnual[0] * 0.01;
        double fatSegundoAno = this.faturamentoAnual[1] * 0.03;
        double fatTerceiroAno = this.faturamentoAnual[2] * 0.05;
        double fatQuartoAno = this.faturamentoAnual[3] * 0.07;
        double fatQuintoAno = this.faturamentoAnual[4] * 0.09;
        double fatSextoAno = this.faturamentoAnual[5] * 0.11;
        double fatSetimoAno = this.faturamentoAnual[6] * 0.13;
        double fatOitavoAno = this.faturamentoAnual[7] * 0.15;
        double fatNonoAno = this.faturamentoAnual[8] * 0.17;
        double fatDecimoAno = this.faturamentoAnual[9] * 0.19;        
        fatPrev = fatPrimeiroAno + fatSegundoAno + fatTerceiroAno + fatQuartoAno + fatQuintoAno +
                  fatSextoAno + fatSetimoAno + fatOitavoAno + fatNonoAno + fatDecimoAno;
        return fatPrev;
    }
    
    // Letra D
    public boolean comparaObjetos(Empresa outraEmpresa){     
        if(this.anoDeFundacao == outraEmpresa.anoDeFundacao){
            return true;
        }
        else{
            return false;
        }
    }
}
