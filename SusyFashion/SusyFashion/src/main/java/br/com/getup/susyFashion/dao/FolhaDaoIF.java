package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Folha;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface FolhaDaoIF extends DaoIF{
    
    public List<Folha> getFolhaEmAberto();
    
}
