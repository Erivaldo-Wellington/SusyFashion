package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Talao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class TalaoDao extends AbstratoDao<Talao> implements TalaoDaoIF{
    
     @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    public TalaoDao() {
        super(Talao.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
