/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Folha;
import br.com.getup.susyFashion.modelo.Saida;
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

    

    public SaidaDao(Class<Saida> entityClass) {
        super(entityClass);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
