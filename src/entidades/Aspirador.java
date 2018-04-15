/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Roberth
 */
public class Aspirador {
    
    private int linhaAtual;
    private int colunaAtual;
    
    public Aspirador(int vet[][]){        
        this.linhaAtual = (int) (Math.random() * 5);
        this.colunaAtual = (int) (Math.random() * 5);        
    }
    
    public void moverDireita(){
        if (this.colunaAtual < 4)
            this.colunaAtual += 1;                
    }
    
    public void moverEsquerda(){
        if (this.colunaAtual > 0)
            this.colunaAtual -= 1;                
    }
    
    public void moverCima(){
        if (this.linhaAtual > 0 )
            this.linhaAtual -= 1;                
    }
    
    public void moverBaixo(){
        if (this.linhaAtual < 4 )
            this.linhaAtual += 1;                
    }

    public int getLinhaAtual() {
        return linhaAtual;
    }

    public void setLinhaAtual(int linhaAtual) {
        this.linhaAtual = linhaAtual;
    }

    public int getColunaAtual() {
        return colunaAtual;
    }

    public void setColunaAtual(int colunaAtual) {
        this.colunaAtual = colunaAtual;
    }
    
}
