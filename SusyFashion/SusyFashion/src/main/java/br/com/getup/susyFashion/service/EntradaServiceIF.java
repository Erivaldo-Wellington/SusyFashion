/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.modelo.Entrada;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface EntradaServiceIF extends ServiceIF {

    public BigDecimal getTotalEntradas();

    public List<Entrada> getEntradaPorDia(Date dataEntrada);

    public List<Entrada> getEntradasRegistradas();

    public List<Entrada> getEntradaPorPeriodo(Date dataInicial, Date dataFinal);

}
