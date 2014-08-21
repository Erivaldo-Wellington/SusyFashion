package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.SaidaServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class SaidaBean implements BeanIF {
    
    @Inject
    private SaidaServiceIF saidaServiceIF;

    public SaidaBean() {
    }
    
    @Override
    public void salvar(Identificavel entidade) {
        saidaServiceIF.salvar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }

    @Override
    public void atualizar(Identificavel entidade) {
        saidaServiceIF.atualizar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }

    @Override
    public void remover(Identificavel entidade) {
        saidaServiceIF.remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return saidaServiceIF.buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return saidaServiceIF.buscarTodos();
    }

    public SaidaServiceIF getSaidaServiceIF() {
        return saidaServiceIF;
    }

    public void setSaidaServiceIF(SaidaServiceIF saidaServiceIF) {
        this.saidaServiceIF = saidaServiceIF;
    }
    
}
