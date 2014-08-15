/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.DaoIF;
import br.com.getup.susyFashion.dao.SaidaDaoIF;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@Stateless
public class SaidaService extends AbstratoService implements SaidaServiceIF {

    @Inject
    private SaidaDaoIF dao;

    @Override
    public DaoIF getDao() {
        return dao;
    }
}
