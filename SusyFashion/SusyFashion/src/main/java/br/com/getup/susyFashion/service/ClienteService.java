/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.ClienteDaoIF;
import br.com.getup.susyFashion.dao.DaoIF;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class ClienteService extends AbstratoService implements ClienteServiceIF{
    
    @Inject
    private ClienteDaoIF dao;
    
    @Override
    public DaoIF getDao() {
        return dao;
    }
    
    
    
    
}
