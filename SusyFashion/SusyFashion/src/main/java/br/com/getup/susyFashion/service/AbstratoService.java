/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.DaoIF;
import br.com.getup.susyFashion.modelo.Identificavel;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author E.Wellington
 */
public abstract class AbstratoService implements ServiceIF{
    
   
            
    public abstract DaoIF getDao();
    
    @Override
    @Transactional
    public void salvar(Identificavel entidade) {
        getDao().salvar(entidade);
    }

    @Override
    @Transactional
    public void atualizar(Identificavel entidade) {
        getDao().atualizar(entidade);
    }
    
    @Override
    @Transactional
    public void remover(Identificavel entidade) {
        getDao().remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
       return getDao().buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return getDao().buscarTodos();
    }

    
    
    
}
