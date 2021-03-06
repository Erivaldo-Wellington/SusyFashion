/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author E.Wellington
 */
public abstract class AbstratoBean implements BeanIF{

    protected Identificavel entidade;
    
    public AbstratoBean() {
    }
    
    public abstract ServiceIF getService();
    
    public abstract Identificavel getEntidade();
    
    public abstract void setEntidade(Identificavel entidade);
    
    @Override
    public void salvar() {
//        try {
            getService().salvar(getEntidade());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
//                FacesMessage.SEVERITY_ERROR, "Erro ao salvar!", ""));
//        }
    }
     
    @Override
    public void atualizar() {
        System.out.println("ENTROU O METODO ATUALIZAR()");
        getService().atualizar(getEntidade());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualizaçao Efetuada com Sucesso", ""));
    }

    @Override
    public void remover() {
        getService().remover(getEntidade());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Removido com Sucesso", ""));
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return getService().buscarTodos();
    }
    
}
