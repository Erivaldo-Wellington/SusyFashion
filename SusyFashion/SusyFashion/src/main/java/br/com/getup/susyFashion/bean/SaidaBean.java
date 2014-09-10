package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Saida;
import br.com.getup.susyFashion.service.SaidaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named(value = "saidaBean")
@RequestScoped
public class SaidaBean extends AbstratoBean {
    
    @Inject
    private SaidaServiceIF saidaServiceIF;

    public SaidaBean() {
    }

    @Override
    public ServiceIF getService() {
      return saidaServiceIF;
    }
    
     @Override
    public Saida getEntidade() {
        if (entidade == null) {
            entidade = new Saida();
        }
        return (Saida) entidade;
    }
    
     @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }
}
