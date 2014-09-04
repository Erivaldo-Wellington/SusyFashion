package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Folha;
import br.com.getup.susyFashion.modelo.Identificavel;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class FolhaDao extends AbstratoDao<Folha> implements FolhaDaoIF{
    
     @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    public FolhaDao() {
        super(Folha.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Identificavel> buscarTodos() {
       return getEntityManager().createQuery("From Folha f").getResultList();
    }
    
}
