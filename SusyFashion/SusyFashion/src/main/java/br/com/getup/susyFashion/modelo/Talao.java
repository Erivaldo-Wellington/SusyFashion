package br.com.getup.susyFashion.modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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

    @OneToMany (mappedBy = "talao", targetEntity = Folha.class, fetch = FetchType.EAGER)  
    private List<Folha> listaFolhas;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    @Override
    public String toString() {
        return "T"+getNumeroTalao();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Talao other = (Talao) obj;
        return true;
    }

    
    
}
