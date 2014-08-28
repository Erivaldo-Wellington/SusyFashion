package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.enumeration.Estados;
import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    private List<Estados> estados;
    
    public ClienteBean() {
        this.estados = Arrays.asList(Estados.values());        
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
   
    public List<Cliente> getClientes() {
        
        List<Identificavel> buscarTodos = buscarTodos();
        List<Cliente> clientesLista = new ArrayList<>();
        for (Identificavel identificavel : buscarTodos) {
            Cliente clienteAux = (Cliente) identificavel;
            clientesLista.add(clienteAux);
        }
        return clientesLista;
    }

    public List<Estados> getEstados() {
        return estados;
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

    
    
    
    // TESTE PARA  O AUTOCOMPLETE
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