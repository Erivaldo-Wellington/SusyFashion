package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.EntradaServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class EntradaBean implements BeanIF {
    
    @Inject
    private EntradaServiceIF entradaServiceIF;

    public EntradaBean() {
    }    

    @Override
    public void salvar(Identificavel entidade) {
        entradaServiceIF.salvar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }

    @Override
    public void atualizar(Identificavel entidade) {
        entradaServiceIF.atualizar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }

    @Override
    public void remover(Identificavel entidade) {
        entradaServiceIF.remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return entradaServiceIF.buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return entradaServiceIF.buscarTodos();
    }

    public EntradaServiceIF getEntradaServiceIF() {
        return entradaServiceIF;
    }

    public void setEntradaServiceIF(EntradaServiceIF entradaServiceIF) {
        this.entradaServiceIF = entradaServiceIF;
    }

}
