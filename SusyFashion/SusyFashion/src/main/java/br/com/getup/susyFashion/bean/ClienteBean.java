package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.enumeration.Estados;
import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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

    // lista de todos os clientes
    private List<Cliente> clientes;

    //lista dos clientes filtrados na tela /cliente/listar.xhtml
    private List<Cliente> clientesFiltrados;

    //lista dos estados do Brasil
    private List<Estados> estados;

    public ClienteBean() {
        this.estados = Arrays.asList(Estados.values());
    }
    
    

    @PostConstruct
    public void init() {
        clientes = new ArrayList<>();
    }

    /**
     * Método para o autoComplete na tela de cadastro de uma nova folha
     *
     * @param query
     * @return
     */
    public List<Cliente> complete(String query) {

        return serviceClienteIF.findByNameLike(query);

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

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }
    

    // MÉTODOS GETTERS E SETTERS
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

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }
    
    
}
