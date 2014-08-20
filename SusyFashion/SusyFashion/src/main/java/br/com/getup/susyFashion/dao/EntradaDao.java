
package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Entrada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
@Stateless
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
    
}
