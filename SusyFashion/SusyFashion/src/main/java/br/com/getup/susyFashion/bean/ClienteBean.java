package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.media.player.RealPlayer;

/**
 *
 * @author Elisângela
 */
@Named
@RequestScoped
public class ClienteBean extends AbstratoBean {

    @Inject
    private ClienteServiceIF serviceClienteIF;
    
    private List<Cliente> clientes;
    
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
   
    
    public List<Identificavel> complete(String query){
//        List<Identificavel> clientes1 = getClientes();
//        System.out.println("lista clientes 1 criada");
//        List<String> sugestoes = new ArrayList<>();
//        for (Identificavel c : clientes1) {
//            System.out.println("entrou no loop");
//            Cliente clienteAux = (Cliente) c;
//            if(clienteAux.getNome().contains(query)){
//                System.out.println("contém alguma coisa");
//                sugestoes.add(clienteAux.getNome());
//            }
//        }
//        return sugestoes;
        return  this.serviceClienteIF.findByNameLike(query);
        
        
       
        
    }

    public List<Identificavel> getClientes() {
        return buscarTodos();
    }
    
    public List<String> lista(String query){
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(query + i);
            }
        return l;
    }
   
    private String t;

    public void setT(String t) {
        this.t = t;
    }

    public String getT() {
        return t;
    }
    
    
   
}