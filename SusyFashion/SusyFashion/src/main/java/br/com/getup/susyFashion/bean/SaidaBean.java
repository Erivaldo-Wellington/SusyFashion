package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Entrada;
import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Saida;
import br.com.getup.susyFashion.service.SaidaServiceIF;
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
@Named(value = "saidaBean")
@RequestScoped
public class SaidaBean extends AbstratoBean {

    @Inject
    private SaidaServiceIF saidaServiceIF;

    private Date dataSaida;

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

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public SaidaBean() {
    }

    @Override
    public SaidaServiceIF getService() {
        return saidaServiceIF;
    }

    @Override
    public Saida getEntidade() {
        if (entidade == null) {
            entidade = new Saida();
        }
        return (Saida) entidade;
    }

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = entidade;
    }

    public List<Saida> getSaidasRegistradas() {
        return getService().getSaidasRegistradas();
    }

    public List<Saida> getSaidasPorDia() {
        Logger logger = Logger.getGlobal();
        logger.log(Level.INFO, "{0}", getDataSaida());
        if (getDataSaida() == null) {

            return new ArrayList();

        } else {
            logger.log(Level.INFO, "{0} Tamanho", getService().getSaidasPorDia(getDataSaida()).size());
            return getService().getSaidasPorDia(getDataSaida());
        }

    }

    public List<Saida> getSaidasPorPeriodo() {
        Logger logger = Logger.getGlobal();
        logger.log(Level.INFO, "Data Inicial: {0}", getDataInicial());
        logger.log(Level.INFO, "Data Final: {0}", getDataFinal());
        if (getDataInicial() == null || getDataFinal() == null) {

            return new ArrayList();

        } else {
            logger.log(Level.INFO, "Entrou no retorno");
            return getService().getSaidaPorPeriodo(getDataInicial(), getDataFinal());
        }

    }
}
