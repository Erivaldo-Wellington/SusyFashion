/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.dao.SaidaDaoIF;
import br.com.getup.susyFashion.dao.qualifiers.SaidaDAO;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Movimentacao;
import br.com.getup.susyFashion.modelo.Saida;
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
public class SaidaService extends AbstratoService implements SaidaServiceIF {

    @Inject @SaidaDAO
    private SaidaDaoIF dao;

    @Override
    public SaidaDaoIF getDao() {
        return dao;
    }

    @Override
    public BigDecimal getTotalSaidas() {
        List<Identificavel> lista = dao.buscarTodos();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Identificavel lista1 : lista) {
            Movimentacao saida = (Saida) lista1;
            valorTotal = valorTotal.add(saida.getValor());
        }

        return valorTotal;
    }

    @Override
    public List<Saida> getSaidasPorDia(Date dataSaida) {
        Logger logger = Logger.getGlobal();
        logger.info("Método Saida Por Dia Acessado");
        
        Query q = getDao().getEntityManager().createQuery("FROM Saida e WHERE e.dataMovimentacao = :data");
        q.setParameter("data", dataSaida);
        
        
        List<Identificavel> buscarTodos = q.getResultList();
        List<Saida> saidasLista = new ArrayList<>();
       
        for (Identificavel identificavel : buscarTodos) {
            Saida saidaAux = (Saida) identificavel;
            
            logger.log(Level.INFO, "Data: {0}", saidaAux.getDataMovimentacao());
            saidasLista.add(saidaAux);
        }

        
        
        return saidasLista;
    }

    @Override
    public List<Saida> getSaidasRegistradas() {
        List<Identificavel> buscarTodos = buscarTodos();
        List<Saida> saidasLista = new ArrayList<>();
       
        for (Identificavel identificavel : buscarTodos) {
            Saida saidaAux = (Saida) identificavel;
            
            System.out.println("Data: "+saidaAux.getDataMovimentacao());
            saidasLista.add(saidaAux);
        }

        return saidasLista;
    }

    @Override
    public List<Saida> getSaidaPorPeriodo(Date dataInicial, Date dataFinal) {
        Logger logger = Logger.getGlobal();
        logger.info("Método Saida Por Periodo Acessado");
        
        Query q = getDao().getEntityManager().createQuery("FROM Saida e WHERE e.dataMovimentacao BETWEEN :dataInicial AND :dataFinal");
        q.setParameter("dataInicial", dataInicial);
        q.setParameter("dataFinal", dataFinal);
        
        
        List<Identificavel> buscarTodos = q.getResultList();
        List<Saida> saidasLista = new ArrayList<>();
       logger.log(Level.INFO, "ResultList Tamanho: {0}", buscarTodos.size());
        
        for (Identificavel identificavel : buscarTodos) {
            Saida saidaAux = (Saida) identificavel;
            
            logger.log(Level.INFO, "Data: {0}", saidaAux.getDataMovimentacao());
            saidasLista.add(saidaAux);
        }
        return saidasLista;

    }
    

}
