/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author E.Wellington
 */
@Entity
@Table(name = "tbl_cliente")
public class Cliente extends Pessoa{

    
    
 @OneToMany (mappedBy = "cliente", targetEntity = Folha.class, fetch = FetchType.LAZY)  
 private  List<Folha> listaFolhas;

    public List<Folha> getListaFolhas() {
        return listaFolhas;
    }

    public void setListaFolhas(List<Folha> listaFolhas) {
        this.listaFolhas = listaFolhas;
    }
 
 
 
 
}
