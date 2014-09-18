package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Identificavel;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

/**
 *
 * @author E.Wellington
 */
@Dependent
public interface DaoIF {
    
    public void salvar(Identificavel entidade);
    
    public void atualizar(Identificavel entidade);
    
    public void remover(Identificavel entidade);
    
    public Identificavel buscarPorId(Long id);
    
    public List<Identificavel> buscarTodos();

    EntityManager getEntityManager();
    
}
