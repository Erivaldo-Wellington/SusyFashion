package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Identificavel;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

/**
 *
 * @author E.Wellington
 * @param <T>
 */

public abstract class AbstratoDao<T extends Identificavel> implements DaoIF {

    static final Logger logger = Logger.getGlobal();
    private Class<T> entityClass;

    public AbstratoDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstratoDao(){}
    
    @Override
    public abstract EntityManager getEntityManager();

    /**
     *
     * @param entidade
     */
    @Override
    public void salvar(Identificavel entidade) {
        logger.log(Level.INFO, "SALVAR DAO");
        try {
             getEntityManager().persist(entidade);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "SERVICE DAO{0}", e.getMessage());
        }
        
       
    }

    @Override
    public void atualizar(Identificavel entidade) {
        getEntityManager().merge(entidade);
        
        
    }

    @Override
    public void remover(Identificavel entidade) {
        Identificavel find = getEntityManager().find(entidade.getClass(), entidade.getId());
        getEntityManager().remove(find);

    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return (Identificavel) getEntityManager().find(entityClass, id);
    }
}
