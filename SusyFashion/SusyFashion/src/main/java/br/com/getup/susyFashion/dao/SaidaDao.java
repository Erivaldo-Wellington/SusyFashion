package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Folha;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Saida;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class SaidaDao extends AbstratoDao<Saida> implements SaidaDaoIF{
    
    @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    

    public SaidaDao() {
        super(Saida.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Identificavel> buscarTodos() {
       return getEntityManager().createQuery("From Saida s").getResultList();
    }
}
