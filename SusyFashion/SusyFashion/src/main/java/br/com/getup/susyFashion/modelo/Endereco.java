package br.com.getup.susyFashion.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author E.Wellington
 */
@Embeddable
public class Endereco implements Serializable{
    
    private String rua;
    
    private long numero;
    
    private String bairro;
    
    private String cep;
    
    private String cidade;
    
    private String estado;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return getRua() + " Nº "+ getNumero() + " Cep: " + getCep() + ", "
                + getCidade() + " - " + getEstado();
    }
    
    
    
}
