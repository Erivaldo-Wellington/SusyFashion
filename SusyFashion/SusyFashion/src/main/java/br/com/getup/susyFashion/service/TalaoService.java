/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.DaoIF;
import br.com.getup.susyFashion.dao.TalaoDaoIF;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class TalaoService extends AbstratoService implements TalaoServiceIF{
    
    @Inject
    private TalaoDaoIF dao;
    
    @Override
    public DaoIF getDao() {
        return dao;
    }
}
