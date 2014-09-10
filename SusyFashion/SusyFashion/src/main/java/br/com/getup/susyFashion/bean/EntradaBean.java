package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Entrada;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.EntradaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named(value = "entradaBean")
@RequestScoped
public class EntradaBean extends AbstratoBean {
    
    @Inject
    private EntradaServiceIF entradaServiceIF;

    @Override
    public ServiceIF getService() {
        return entradaServiceIF;
    }

    public EntradaBean() {
    }
    
     @Override
    public Entrada getEntidade() {
        if (entidade == null) {
            entidade = new Entrada();
        }
        return (Entrada) entidade;
    }
    
    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }
    
    
}
