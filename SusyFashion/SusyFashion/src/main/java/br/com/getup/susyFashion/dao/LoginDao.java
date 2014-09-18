
package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Login;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MarkusPatriota
 */
public class LoginDao extends AbstratoLoginDao<Login> implements LoginDaoIF {
    @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public LoginDao() {
        super(Login.class);
    }
    
}
