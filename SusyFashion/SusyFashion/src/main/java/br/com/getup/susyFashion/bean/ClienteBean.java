package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named
@RequestScoped
public class ClienteBean extends AbstratoBean {

    @Inject
    private ClienteServiceIF serviceClienteIF;
    
    private List<SelectItem> selectItens;
    
    public ClienteBean() {
    }

    @Override
    public ServiceIF getService() {
        return serviceClienteIF;
    }

    @Override
    public Cliente getEntidade() {
        if (entidade == null) {
            entidade = new Cliente();
        }
        return (Cliente) entidade;
    }
   
    
     public  List<SelectItem> getSelectItens() {
        List<Identificavel> buscarTodos = buscarTodos();
        
        selectItens = new ArrayList<>();
        
//        selectItens = (SelectItem[]) buscarTodos.toArray();
        
         for (Identificavel identificavel : buscarTodos) {
             
            selectItens.add(new SelectItem(identificavel));
         }
            
        
        
        
        return selectItens;
    }
    
   
}