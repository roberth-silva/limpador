/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import entidades.ALimpa;
import entidades.ASuja;

/**
 *
 * @author Roberth
 */
public class Ambiente {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    
    public static final int maxLinha = 5;
    public static final int maxColuna = 5;
            
    int[][] tabuleiro;
    ALimpa aLimpa;
    ASuja aSuja;

    public ALimpa getaLimpa() {
        return aLimpa;
    }

    public void setaLimpa(ALimpa aLimpa) {
        this.aLimpa = aLimpa;
    }

    public ASuja getaSuja() {
        return aSuja;
    }

    public void setaSuja(ASuja aSuja) {
        this.aSuja = aSuja;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    public Ambiente(){
        this.tabuleiro = new int[maxLinha][maxColuna];
    }
    
    public void iniciaAmbiente(){
        for(int i=0;i<maxLinha;i++){
            for(int j=0;j<maxColuna;j++)                
                this.tabuleiro[i][j] = (int) (Math.random() * 2);
        }
    }
    
    public void limpaAmbiente(){
        for(int i=0;i<maxLinha;i++){
            for(int j=0;j<maxColuna;j++)                
                this.tabuleiro[i][j] = 0;       
        }
    }
    
    public boolean temLugarSujo(){        
        for(int i=0;i<maxLinha;i++){
            for(int j=0;j<maxColuna;j++){
                if (this.tabuleiro[i][j]==1)
                    return true;
            }
        }
        return false;
    }
    
    public void mostraAmbiente(){
        for(int i=0;i<maxLinha;i++){
            for(int j=0;j<maxColuna;j++){
                if(this.aLimpa.getLinhaAtual()== i && this.aLimpa.getColunaAtual() == j){
                    System.out.print(" " + (char)27 + "[32m" + this.tabuleiro[i][j] + (char)27 + "[0m" +"  ");
                    
                }else if(this.aSuja.getLinhaAtual()== i && this.aSuja.getColunaAtual() == j){
                    System.out.print(" " + (char)27 + "[31m" + this.tabuleiro[i][j] + (char)27 + "[0m" +"  ");
                    
                }else{
                    System.out.print(" " + this.tabuleiro[i][j] + "  ");
                }
                
            }
            System.out.println("");
        }
    }
}
