package Unidade1.PreProva2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Arquivo arquivo = new Arquivo();
        Cliente c1 = new Cliente("Carla");
        c1.addDoce(new Doce(1, "Bala de goma", 1f));
        c1.addDoce(new Doce(2, "Bolo de amora", 10f));
        arquivo.salvar("Dia 1", "Arquivo01", c1);
        
        Cliente c2 = new Cliente("Josué");
        c2.addDoce(new Doce(1, "Bala de goma", 1f));
        arquivo.salvar("Dia 1", "Arquivo01", c2);
        
        Cliente cliente = arquivo.ler("Dia 1", "Arquivo01");
        System.out.println(cliente.toString());
        
        
        ArrayList<Cliente> clientes = arquivo.lerLista("Dia 1", "Arquivo01");
        for(Cliente cli : clientes){
            System.out.println(cli.toString());
        }
        
        String arquivos = arquivo.listarArquivos("Dia 1");
        System.out.println(arquivos);
    }
}
