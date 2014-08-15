/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E.Wellington
 */
public class ClienteDao extends AbstratoDao<Cliente>{
    
    @PersistenceContext(name = "susyFashion")
    private EntityManager em;

    public ClienteDao(Class<Cliente> entityClass) {
        super(entityClass);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
