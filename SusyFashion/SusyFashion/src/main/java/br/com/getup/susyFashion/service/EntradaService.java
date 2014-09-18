/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.EntradaDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.EntradaDAO;
import br.com.getup.susyFashion.modelo.Entrada;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Movimentacao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author E.Wellington
 */
@RequestScoped
public class EntradaService extends AbstratoService implements EntradaServiceIF {
    
    
    @Inject @EntradaDAO
    private EntradaDaoIF dao;

    @Override
    public EntradaDaoIF getDao() {
        return dao;
    }

    @Override
    public BigDecimal getTotalEntradas() {
        List<Identificavel> lista = buscarTodos();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Identificavel lista1 : lista) {
            Movimentacao entrada = (Entrada) lista1;
            valorTotal = valorTotal.add(entrada.getValor());
        }

        return valorTotal;
    }

    @Override
    public List<Entrada> getEntradaPorDia(Date dataEntrada) {
        Logger logger = Logger.getGlobal();
        logger.info("Método Entrada Por Dia Acessado");
        
        Query q = getDao().getEntityManager().createQuery("FROM Entrada e WHERE e.dataMovimentacao = :data");
        q.setParameter("data", dataEntrada);
        
        
        List<Identificavel> buscarTodos = q.getResultList();
        List<Entrada> entradasLista = new ArrayList<>();
       
        for (Identificavel identificavel : buscarTodos) {
            Entrada entradaAux = (Entrada) identificavel;
            
            logger.log(Level.INFO, "Data: {0}", entradaAux.getDataMovimentacao());
            entradasLista.add(entradaAux);
        }

        
        
        return entradasLista;
    }

    @Override
    public List<Entrada> getEntradasRegistradas() {
        List<Identificavel> buscarTodos = buscarTodos();
        List<Entrada> entradasLista = new ArrayList<>();
       
        for (Identificavel identificavel : buscarTodos) {
            Entrada entradaAux = (Entrada) identificavel;
            
            System.out.println("Data: "+entradaAux.getDataMovimentacao());
            entradasLista.add(entradaAux);
        }

        return entradasLista;
    }

    @Override
    public List<Entrada> getEntradaPorPeriodo(Date dataInicial, Date dataFinal) {
        Logger logger = Logger.getGlobal();
        logger.info("Método Entrada Por Periodo Acessado");
        
        Query q = getDao().getEntityManager().createQuery("FROM Entrada e WHERE e.dataMovimentacao BETWEEN :dataInicial AND :dataFinal");
        q.setParameter("dataInicial", dataInicial);
        q.setParameter("dataFinal", dataFinal);
        
        
        List<Identificavel> buscarTodos = q.getResultList();
        List<Entrada> entradasLista = new ArrayList<>();
       logger.log(Level.INFO, "ResultList Tamanho: {0}", buscarTodos.size());
        
        for (Identificavel identificavel : buscarTodos) {
            Entrada entradaAux = (Entrada) identificavel;
            
            logger.log(Level.INFO, "Data: {0}", entradaAux.getDataMovimentacao());
            entradasLista.add(entradaAux);
        }
        return entradasLista;

    }
    
    

}
