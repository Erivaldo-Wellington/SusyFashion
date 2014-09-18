/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.service.EntradaServiceIF;
import br.com.getup.susyFashion.service.SaidaServiceIF;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author WitaloCarlos
 */
@Named(value = "relatorioBean")
@RequestScoped
public class RelatorioBean implements Serializable{
    
   
    @Inject
    private EntradaServiceIF entradaService;
    @Inject
    private SaidaServiceIF saidaService;

    public BigDecimal getBalanco() {
        BigDecimal balanco = entradaService.getTotalEntradas().subtract(saidaService.getTotalSaidas());

        return balanco;
    }
    
    
    
}
