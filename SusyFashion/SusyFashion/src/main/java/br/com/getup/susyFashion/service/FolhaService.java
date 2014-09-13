/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.FolhaDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.FolhaDAO;
import br.com.getup.susyFashion.modelo.Folha;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class FolhaService extends AbstratoService implements FolhaServiceIF {
    
    @Inject @FolhaDAO
    private FolhaDaoIF dao;

    @Override
    public FolhaDaoIF getDao() {
        return dao;
    }
    
    @Override
    public List<Folha> getFolhaEmAberto(){
       return  getDao().getFolhaEmAberto();
        
    }

}
