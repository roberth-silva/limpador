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
public class ASuja extends Aspirador {
    
    public ASuja(int[][] vet) {
        super(vet);
    }
    
    public void sujar(int[][] vet){
        if (vet[getLinhaAtual()][getColunaAtual()] == 0)
            vet[getLinhaAtual()][getColunaAtual()] = 1;    
    }  
}
