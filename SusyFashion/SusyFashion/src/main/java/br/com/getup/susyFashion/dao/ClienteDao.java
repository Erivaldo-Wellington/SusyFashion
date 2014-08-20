package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class ClienteDao extends AbstratoDao<Cliente> implements ClienteDaoIF{
    
    @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    public ClienteDao() {
        super(Cliente.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
