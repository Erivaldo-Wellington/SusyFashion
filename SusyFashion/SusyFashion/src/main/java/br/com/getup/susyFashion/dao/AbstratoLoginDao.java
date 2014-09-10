package br.com.getup.susyFashion.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author MarkusPatriota
 * @param <Login>
 */
public abstract class AbstratoLoginDao<Login> {
    
    private Class<Login> entityClass;

    public AbstratoLoginDao(Class<Login> entityClass) {
        this.entityClass = entityClass;
    }
    
    public abstract EntityManager getEntityManager();

    
    public void cadastrarLogin(Login login) {
        getEntityManager().persist(login);
    }
    
    public Login buscarPorLogin(String usuario, String senha) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Login> c = cb.createQuery(entityClass);
       
        Root<Login> login= c.from(entityClass);
        c.distinct(true).where(cb.equal(login, login));
        
        c.where(cb.equal(login.get("usuario"), cb.parameter(String.class, "usuario")));
        c.where(cb.equal(login.get("senha"), cb.parameter(String.class, "senha")));
        
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("usuario", usuario);
        q.setParameter("senha", senha);

        return (Login) q.getSingleResult();
    } 
    
}
