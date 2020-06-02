package Unidade1.PreProva2;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private ArrayList<Doce> docesComprados;

    public Cliente(String nome) {
        docesComprados = new ArrayList<Doce>();
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Doce> getDocesComprados() {
        return docesComprados;
    }
    
    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome inválido");
    }

    public void addDoce(Doce doce){
        if(doce != null){
            this.docesComprados.add(doce);
        }
    }
    
    public float getTotalCompra(){
        return !docesComprados.isEmpty() ? calcularPrecoTotalCompra() : 0;
    }
    
    private float calcularPrecoTotalCompra(){
        float temp = 0;
        for(Doce doce : this.docesComprados){
            temp += doce.getPreco();
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Dados do cliente: " 
                + getNome() + "\n"
                + "Total da compra " + getTotalCompra() + "\n";
    }
}
