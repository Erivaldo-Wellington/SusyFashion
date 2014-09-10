/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.TalaoDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.TalaoDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class TalaoService extends AbstratoService implements TalaoServiceIF{
    
    @Inject @TalaoDAO
    private TalaoDaoIF dao;
    
    @Override
    public TalaoDaoIF getDao() {
        return dao;
    }

   
    
    
}
