package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Folha;
import br.com.getup.susyFashion.service.FolhaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class FolhaBean extends AbstratoBean{
    
    @Inject
    private FolhaServiceIF folhaServiceIF;

    public FolhaBean() {
    }

    @Override
    public ServiceIF getService() {
        return folhaServiceIF;
    }

     @Override
    public Folha getEntidade() {
        if (entidade == null) {
            entidade = new Folha();
        }
        return (Folha) entidade;
    }
    
}
