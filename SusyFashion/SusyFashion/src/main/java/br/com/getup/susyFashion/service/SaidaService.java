/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.SaidaDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.SaidaDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class SaidaService extends AbstratoService implements SaidaServiceIF {

    @Inject @SaidaDAO
    private SaidaDaoIF dao;

    @Override
    public SaidaDaoIF getDao() {
        return dao;
    }
}
