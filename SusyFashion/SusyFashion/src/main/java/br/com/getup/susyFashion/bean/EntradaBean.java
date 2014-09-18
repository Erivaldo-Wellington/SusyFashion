package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Entrada;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.EntradaServiceIF;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named(value = "entradaBean")
@RequestScoped
public class EntradaBean extends AbstratoBean {

    private Date dataEntrada;
    
    private Date dataInicial;
    private Date dataFinal;

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    
    
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public EntradaServiceIF getEntradaServiceIF() {
        return entradaServiceIF;
    }

    public void setEntradaServiceIF(EntradaServiceIF entradaServiceIF) {
        this.entradaServiceIF = entradaServiceIF;
    }

    @Inject
    private EntradaServiceIF entradaServiceIF;

    @Override
    public EntradaServiceIF getService() {
        return entradaServiceIF;
    }

    public EntradaBean() {
    }

    @Override
    public Entrada getEntidade() {
        if (entidade == null) {
            entidade = new Entrada();
        }
        return (Entrada) entidade;
    }

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }

    public List<Entrada> getEntradasRegistradas() {
        return getService().getEntradasRegistradas();
    }

    public List<Entrada> getEntradasPorDia() {
        Logger logger = Logger.getGlobal();
        logger.log(Level.INFO, "{0}", getDataEntrada());
        if (getDataEntrada() == null) {
            
            return new ArrayList();
       
        } else {
            logger.log(Level.INFO, "{0} Tamanho", getService().getEntradaPorDia(getDataEntrada()).size());
            return getService().getEntradaPorDia(getDataEntrada());
        }

    }
    
    public List<Entrada> getEntradasPorPeriodo() {
        Logger logger = Logger.getGlobal();
        logger.log(Level.INFO, "Data Inicial: {0}", getDataInicial());
        logger.log(Level.INFO, "Data Final: {0}", getDataFinal());
        if (getDataInicial() == null || getDataFinal() == null) {
            
            return new ArrayList();
       
        } else {
            logger.log(Level.INFO, "Entrou no retorno");
            return getService().getEntradaPorPeriodo(getDataInicial(), getDataFinal());
        }

    }


}
