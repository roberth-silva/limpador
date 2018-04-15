/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import ambiente.Ambiente;
import entidades.ASuja;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import testethread.TesteThread;

/**
 *
 * @author Roberth
 */

public class ThreadSuja extends Thread{
    
    int cont;
    int[][] tabuleiro;
    ASuja aSuja;
    Ambiente ambiente;
    
    public ThreadSuja(Ambiente ambiente, ASuja aSuja){
        this.cont=0;
        this.ambiente = ambiente;
        this.tabuleiro = this.ambiente.getTabuleiro();
        this.aSuja = aSuja;
    }
    
    public void escolheMovimento(){
        /*
        0 - nao faz nada
        1 - direita
        2 - esquerda
        3 - cima
        4 - baixo
        */
        
        int movimento = (int) new Random().nextInt(4 - 1 + 1) + 1;
        switch(movimento){
            case 0:
                break;
            case 1:
                this.aSuja.moverDireita();
                break;
            case 2:
                this.aSuja.moverEsquerda();
                break;
            case 3:
                this.aSuja.moverCima();
                break;
            case 4:
                this.aSuja.moverBaixo();
                break;
        }
    }
    
    public void acao(){
        if (this.tabuleiro[this.aSuja.getLinhaAtual()][this.aSuja.getColunaAtual()] == 0)
            this.tabuleiro[this.aSuja.getLinhaAtual()][this.aSuja.getColunaAtual()] = 1;
        else
            escolheMovimento();
        this.ambiente.setTabuleiro(tabuleiro);
    }
    
    @Override
    public void run(){
        try {
            do{
                acao();
                System.out.println("A. Suja: (" + aSuja.getLinhaAtual() + ", " + aSuja.getColunaAtual()+ "), Rod.: " + ++cont );                              
                ambiente.mostraAmbiente();
                System.out.println("");
                System.out.println("");
                Thread.sleep(300);
            }while(ambiente.temLugarSujo());
                 
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
