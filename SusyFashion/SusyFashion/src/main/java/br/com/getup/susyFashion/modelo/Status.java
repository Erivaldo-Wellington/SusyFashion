package br.com.getup.susyFashion.modelo;

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
