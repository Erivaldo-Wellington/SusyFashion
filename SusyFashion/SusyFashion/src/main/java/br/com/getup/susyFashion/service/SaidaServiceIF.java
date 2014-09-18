/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.modelo.Saida;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface SaidaServiceIF extends ServiceIF {

    public BigDecimal getTotalSaidas();

    public List<Saida> getSaidasPorDia(Date dataSaidas);

    public List<Saida> getSaidasRegistradas();

    public List<Saida> getSaidaPorPeriodo(Date dataInicial, Date dataFinal);
}
