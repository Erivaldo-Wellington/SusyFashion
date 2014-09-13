package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Folha;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.FolhaServiceIF;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.ArrayList;
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
public class FolhaBean extends AbstratoBean {

    @Inject
    private FolhaServiceIF folhaServiceIF;

    private List<Folha> folhasDoCliente;

    private List<Folha> folhasFiltradas;

    private String nomeCliente;

    public FolhaBean() {
    }

    @PostConstruct
    public void init() {
        folhasDoCliente = new ArrayList<>();
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

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }

    public List<Folha> getFolhasDoCliente() {
//        List<Identificavel> buscarTodos = folhaServiceIF.buscarTodos();
//
//        List<Folha> listaAuxiliar = new ArrayList<>();
//
//        for (Identificavel identificavel : buscarTodos) {
//            Folha aux = (Folha) identificavel;
//            if (aux.getStatus().equals("aberta")) {
//                System.out.println(aux.getStatus());
//                listaAuxiliar.add(aux);
//            }
//        }
//        setFolhasDoCliente(listaAuxiliar);
        List<Folha> folhaEmAberto = folhaServiceIF.getFolhaEmAberto();
        setFolhasDoCliente(folhaEmAberto);
        return folhasDoCliente;
    }

    public void setFolhasDoCliente(List<Folha> folhasDoCliente) {
        this.folhasDoCliente = folhasDoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Folha> getFolhasFiltradas() {
        return folhasFiltradas;
    }

    public void setFolhasFiltradas(List<Folha> folhasFiltradas) {
        this.folhasFiltradas = folhasFiltradas;
    }

    //está com problemas
    public void darBaixaConta() {

        Long id = getEntidade().getId();

        Folha buscarPorId = (Folha) folhaServiceIF.buscarPorId(id);

        buscarPorId.setStatus("Fechada");

        atualizar(buscarPorId);
    }

}
