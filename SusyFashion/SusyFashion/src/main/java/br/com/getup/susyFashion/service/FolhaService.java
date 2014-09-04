/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.FolhaDaoIF;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class FolhaService extends AbstratoService implements FolhaServiceIF {
    
    @Inject
    private FolhaDaoIF dao;

    @Override
    public FolhaDaoIF getDao() {
        return dao;
    }

}
