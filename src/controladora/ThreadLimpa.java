/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import ambiente.Ambiente;
import entidades.ALimpa;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import testethread.TesteThread;

/**
 *
 * @author Roberth
 */
public class ThreadLimpa extends Thread {
    
    int cont;
    int[][] tabuleiro;
    ALimpa aLimpa;
    Ambiente ambiente;
    
    public ThreadLimpa(Ambiente ambiente, ALimpa aLimpa){
        this.cont=0;
        this.ambiente = ambiente;
        this.tabuleiro = this.ambiente.getTabuleiro();
        this.aLimpa = aLimpa;
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
                this.aLimpa.moverDireita();
                break;
            case 2:
                this.aLimpa.moverEsquerda();
                break;
            case 3:
                this.aLimpa.moverCima();
                break;
            case 4:
                this.aLimpa.moverBaixo();
                break;
        }
    }
    
    public void acao(){
        if (this.tabuleiro[this.aLimpa.getLinhaAtual()][this.aLimpa.getColunaAtual()] == 1)
            this.tabuleiro[this.aLimpa.getLinhaAtual()][this.aLimpa.getColunaAtual()] = 0;
        else
            escolheMovimento();
        this.ambiente.setTabuleiro(tabuleiro);
    }
    
    @Override
    public void run(){
        try {
            do{
                acao();
                System.out.println("A. Limpa: (" + aLimpa.getLinhaAtual() + ", " + aLimpa.getColunaAtual()+ "), Rod.: " + ++cont);                              
                ambiente.mostraAmbiente();
                System.out.println("");
                System.out.println("");
                Thread.sleep(50);
            }while(ambiente.temLugarSujo());
                 
        } catch (InterruptedException ex) {
            Logger.getLogger(TesteThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
}
