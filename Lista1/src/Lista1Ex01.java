
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex01 extends Furbot {

    @Override
    public void inteligencia() throws Exception 
    {
        andarDireita();
        andarDireita();
        andarDireita();
        diga ("Cheguei!");
        
    
        
    }
    public static void main(String[] args) 
    {
        MundoVisual.iniciar("Lista1Ex01.xml");
    }
}
