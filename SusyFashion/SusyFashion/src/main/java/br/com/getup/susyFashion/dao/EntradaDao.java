
package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Entrada;
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
public class EntradaDao extends AbstratoDao<Entrada> implements EntradaDaoIF{
    
    
     @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    public EntradaDao() {
        super(Entrada.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Identificavel> buscarTodos() {
       return getEntityManager().createQuery("From Entrada e").getResultList();
    }
}
