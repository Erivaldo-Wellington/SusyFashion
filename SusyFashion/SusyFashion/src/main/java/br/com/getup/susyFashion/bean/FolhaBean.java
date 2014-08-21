package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.FolhaServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class FolhaBean implements BeanIF {
    
    @Inject
    private FolhaServiceIF folhaServiceIF;

    public FolhaBean() {
    }

    @Override
    public void salvar(Identificavel entidade) {
        folhaServiceIF.salvar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }

    @Override
    public void atualizar(Identificavel entidade) {
        folhaServiceIF.atualizar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }

    @Override
    public void remover(Identificavel entidade) {
        folhaServiceIF.remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return folhaServiceIF.buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return folhaServiceIF.buscarTodos();
    }

    public FolhaServiceIF getFolhaServiceIF() {
        return folhaServiceIF;
    }

    public void setFolhaServiceIF(FolhaServiceIF folhaServiceIF) {
        this.folhaServiceIF = folhaServiceIF;
    }
    
}
