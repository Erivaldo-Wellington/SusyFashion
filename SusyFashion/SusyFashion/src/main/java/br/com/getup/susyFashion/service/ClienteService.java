/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.ClienteDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.ClienteDAO;
import br.com.getup.susyFashion.modelo.Cliente;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class ClienteService extends AbstratoService implements ClienteServiceIF{
    
    @Inject @ClienteDAO
    private ClienteDaoIF dao;
    
    @Override
    public ClienteDaoIF getDao() {
        return dao;
    }

    @Override
    public List<Cliente> findByNameLike(String query) {
        return getDao().findByNameLike(query);
    }

    
    
    
    
    
}
