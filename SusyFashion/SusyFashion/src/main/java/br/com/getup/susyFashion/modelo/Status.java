/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.modelo;

import javax.persistence.Embeddable;

/**
 *
 * @author E.Wellington
 */

public enum Status {
    
    ABERTA ("aberta"),FECHADA("fechada");
    
    private String valor;

    private Status(String valorStatus) {
        valor = valorStatus;
    }
    
    private String getValor(){
        return valor;
    }
}
