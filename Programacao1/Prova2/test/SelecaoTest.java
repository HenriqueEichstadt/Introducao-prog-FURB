/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique Alexsander Eichstädt
 */
public class SelecaoTest {

    public SelecaoTest() {
    }

    /**
     * Testando getIdadeMedia da classe Seleção.
     */
    @Test
    public void testGetIdadeMediaSelecaoBrasil() {
        System.out.println("getIdadeMedia Brasil");
        Jogador jogador1 = new Jogador("Alisson", "Goleiro", 1.91f, 26);
        Jogador jogador2 = new Jogador("Filipe Luís", "Defensor", 1.82f, 33);
        Jogador jogador3 = new Jogador("Gabriel Jesus", "Atacante", 1.75f, 22);
        Selecao selecao = new Selecao("Brasil", "Tite", 3);
        selecao.addJogador(jogador1);
        selecao.addJogador(jogador2);
        selecao.addJogador(jogador3);
        
        int resultadoExperado = 27;
        int result = selecao.getIdadeMedia();
        assertEquals(resultadoExperado, result, 0.01);
    }
    
        @Test
    public void testGetIdadeMediaSelecaoArgentina() {
        System.out.println("getIdadeMedia Argentina");
        Jogador jogador1 = new Jogador("Otamendi", "Defensor", 1.83f, 31);
        Jogador jogador2 = new Jogador("Di María", "Meia", 1.80f, 31);
        Jogador jogador3 = new Jogador("Messi", "Atacante", 1.70f, 31);
        Selecao selecao = new Selecao("Argentina", "Lionel Scaloni", 11);
        selecao.addJogador(jogador1);
        selecao.addJogador(jogador2);
        selecao.addJogador(jogador3);
        
        int resultadoExperado = 31;
        int result = selecao.getIdadeMedia();
        assertEquals(resultadoExperado, result, 0.01);
    }

    /**
     * Test of getQuantosAbaixoMediaAltura method, of class Selecao.
     */
    @Test
    public void testGetQuantosAbaixoMediaAlturaBrasil() {
        System.out.println("getQuantosAbaixoMediaAltura Brasil");
        Jogador jogador1 = new Jogador("Alisson", "Goleiro", 1.91, 26);
        Jogador jogador2 = new Jogador("Filipe Luís", "Defensor", 1.82, 33);
        Jogador jogador3 = new Jogador("Gabriel Jesus", "Atacante", 1.75, 22);
        Selecao selecao = new Selecao("Brasil", "Tite", 3);
        selecao.addJogador(jogador1);
        selecao.addJogador(jogador2);
        selecao.addJogador(jogador3);
        
        int resultadoExperado = 2;
        int result = selecao.getQuantosAbaixoMediaAltura();
        assertEquals(resultadoExperado, result, 0.01);
    }
    
        @Test
    public void testGetQuantosAbaixoMediaAlturaArgentina() {
        System.out.println("getQuantosAbaixoMediaAltura Brasil");
        Jogador jogador1 = new Jogador("Otamendi", "Defensor", 1.83, 31);
        Jogador jogador2 = new Jogador("Di María", "Meia", 1.80, 31);
        Jogador jogador3 = new Jogador("Messi", "Atacante", 1.70, 31);
        Selecao selecao = new Selecao("Argentina", "Lionel Scaloni", 11);
        selecao.addJogador(jogador1);
        selecao.addJogador(jogador2);
        selecao.addJogador(jogador3);
        
        int resultadoExperado = 1;
        int result = selecao.getQuantosAbaixoMediaAltura();
        assertEquals(resultadoExperado, result, 0.01);
    }

    /**
     * Test of getIdade method, of class Jogador.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testGetIdade() {
        System.out.println("getIdade");
        Jogador jogador = new Jogador("Henrique", "Atacante", 1.85f, 10);
        jogador.setIdade(-10);
    }


}
