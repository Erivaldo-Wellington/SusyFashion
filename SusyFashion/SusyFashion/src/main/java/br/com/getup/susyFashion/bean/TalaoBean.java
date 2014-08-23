package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Talao;
import br.com.getup.susyFashion.service.ServiceIF;
import br.com.getup.susyFashion.service.TalaoServiceIF;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class TalaoBean extends AbstratoBean {
    
    @Inject
    private TalaoServiceIF talaoServiceIF;

    public TalaoBean() {
    }

    @Override
    public ServiceIF getService() {
        return talaoServiceIF;
    }
    
     @Override
    public Talao getEntidade() {
        if (entidade == null) {
            entidade = new Talao();
        }
        return (Talao) entidade;
    }
    
    
}
