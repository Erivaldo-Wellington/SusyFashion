package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.modelo.Identificavel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public List<Identificavel> buscarTodos() {
       return getEntityManager().createQuery("From Cliente c").getResultList();
    }

    @Override
    public List<Cliente> findByNameLike(String query) {
        Query createQuery = getEntityManager().createQuery("select c from Cliente c where c.nome like :nome");
        createQuery.setParameter("nome", "%" + query + "%");
        
       
        return createQuery.getResultList();
    }
    
    
    
    
}
