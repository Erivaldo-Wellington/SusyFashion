package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.TalaoServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class TalaoBean implements BeanIF {
    
    @Inject
    private TalaoServiceIF talaoServiceIF;

    public TalaoBean() {
    }

    @Override
    public void salvar(Identificavel entidade) {
        talaoServiceIF.salvar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }

    @Override
    public void atualizar(Identificavel entidade) {
        talaoServiceIF.atualizar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }

    @Override
    public void remover(Identificavel entidade) {
        talaoServiceIF.remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return talaoServiceIF.buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return talaoServiceIF.buscarTodos();
    }

    public TalaoServiceIF getTalaoServiceIF() {
        return talaoServiceIF;
    }

    public void setTalaoServiceIF(TalaoServiceIF talaoServiceIF) {
        this.talaoServiceIF = talaoServiceIF;
    }
    
}
