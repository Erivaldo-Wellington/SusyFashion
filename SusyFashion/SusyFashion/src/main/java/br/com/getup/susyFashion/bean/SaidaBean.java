package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.SaidaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class SaidaBean extends AbstratoBean {
    
    @Inject
    private SaidaServiceIF saidaServiceIF;

    public SaidaBean() {
    }

    @Override
    public ServiceIF getService() {
      return saidaServiceIF;
    }
    
    
}
