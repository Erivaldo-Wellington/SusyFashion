package br.com.getup.susyFashion.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author E.Wellington
 */
@Entity
@Table(name = "tbl_folha")
public class Folha implements Identificavel{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @CascadeOnDelete
    @ManyToOne (cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    private String descricao;
    
    private Long numeroFolha;
    
    private String status;
    
    @ManyToOne 
    @JoinColumn(name = "talao_id")
    private Talao talao;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getNumeroFolha() {
        return numeroFolha;
    }

    public void setNumeroFolha(Long numeroFolha) {
        this.numeroFolha = numeroFolha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Talao getTalao() {
        return talao;
    }

    public void setTalao(Talao talao) {
        this.talao = talao;
    }

    @Override
    public String toString() {
        return "F: "+ getNumeroFolha();
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Folha other = (Folha) obj;
        return true;
    }
    
    
}
