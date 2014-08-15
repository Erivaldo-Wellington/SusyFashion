/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Talao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
public class TalaoDao extends AbstratoDao<Talao> implements TalaoDaoIF{
    
     @PersistenceContext(unitName = "susyFashion")
    private EntityManager em;

    public TalaoDao(Class<Talao> entityClass) {
        super(entityClass);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
