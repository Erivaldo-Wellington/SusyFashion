/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author E.Wellington
 */
@Entity
@Table(name = "tbl_talao")
public class Talao implements Identificavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long numeroTalao;

    @OneToMany (mappedBy = "talao", targetEntity = Folha.class, fetch = FetchType.LAZY)  
    private List<Folha> listaFolhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumeroTalao() {
        return numeroTalao;
    }

    public void setNumeroTalao(long numeroTalao) {
        this.numeroTalao = numeroTalao;
    }

    public List<Folha> getListaFolhas() {
        return listaFolhas;
    }

    public void setListaFolhas(List<Folha> listaFolhas) {
        this.listaFolhas = listaFolhas;
    }
    
    
}
