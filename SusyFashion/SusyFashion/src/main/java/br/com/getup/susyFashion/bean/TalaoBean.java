package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Talao;
import br.com.getup.susyFashion.service.ServiceIF;
import br.com.getup.susyFashion.service.TalaoServiceIF;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named(value = "talaoBean")
@RequestScoped
public class TalaoBean extends AbstratoBean {

    @Inject
    private TalaoServiceIF talaoServiceIF;

    private List<Talao> listaTalao;

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

     @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }

    /**
     * @return the listaTalao
     */
    public List<Talao> getListaTalao() {

        List<Identificavel> buscarTodos = buscarTodos();
        List<Talao> taloesLista = new ArrayList<>();
        for (Identificavel identificavel : buscarTodos) {
            Talao taloesAux = (Talao) identificavel;
            taloesLista.add(taloesAux);
        }
        return taloesLista;
    }

    public boolean salvarTalao() {

        Talao aux = (Talao) getEntidade();

        List<Talao> listaTalao1 = getListaTalao();

        for (Talao talao : listaTalao1) {
            if (talao.getNumeroTalao() == aux.getNumeroTalao()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Número de Talão já existe", ""));
                return false;
            }
        }
        getService().salvar(getEntidade());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));

        return true;

    }
}
