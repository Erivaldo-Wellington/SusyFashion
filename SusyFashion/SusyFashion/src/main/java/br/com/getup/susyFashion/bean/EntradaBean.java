package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Entrada;
import br.com.getup.susyFashion.service.EntradaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
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
    
    
}
