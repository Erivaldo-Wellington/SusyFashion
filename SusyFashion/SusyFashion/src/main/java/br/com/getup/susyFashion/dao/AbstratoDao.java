/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Identificavel;
import com.sun.corba.se.spi.ior.Identifiable;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author E.Wellington
 */
public abstract class AbstratoDao<T extends Identificavel> implements DaoIF{

    @Override
    public void criar(Identifiable entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract EntityManager getEntityManager();
    
    @Override
    public void editar(Identifiable entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Identifiable entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identifiable buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Identifiable> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
