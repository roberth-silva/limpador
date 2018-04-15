/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testethread;

import ambiente.Ambiente;
import controladora.ThreadLimpa;
import controladora.ThreadSuja;
import entidades.ALimpa;
import entidades.ASuja;

/**
 *
 * @author Roberth
 */
public class TesteThread{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ambiente ambiente = new Ambiente();
        ambiente.iniciaAmbiente();
        ALimpa aLimpa = new ALimpa(ambiente.getTabuleiro());
        ASuja aSuja = new ASuja(ambiente.getTabuleiro());
        ambiente.setaLimpa(aLimpa);
        ambiente.setaSuja(aSuja);
        ThreadLimpa tLimpeza = new ThreadLimpa(ambiente, aLimpa);
        ThreadSuja tSujeira = new ThreadSuja(ambiente, aSuja);
        tLimpeza.start();        
        tSujeira.start();
    }
    
}
