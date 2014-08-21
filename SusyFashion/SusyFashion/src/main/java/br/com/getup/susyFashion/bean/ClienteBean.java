package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.service.ClienteServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class ClienteBean extends AbstratoBean{

    @Inject
    private ClienteServiceIF serviceClienteIF;
    
    @Override
    public ServiceIF getService() {
        return serviceClienteIF;
    }

    public ClienteBean() {
    }
    
    
   
}
