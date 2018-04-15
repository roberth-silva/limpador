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
public class ALimpa extends Aspirador {

    public ALimpa(int[][] vet) {
        super(vet);
    }
    
    public void limpar(int[][] vet){
        if (vet[getLinhaAtual()][getColunaAtual()] == 1)
            vet[getLinhaAtual()][getColunaAtual()] = 0;    
    }    
}
