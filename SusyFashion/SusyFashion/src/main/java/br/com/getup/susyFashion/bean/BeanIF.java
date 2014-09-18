package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import java.util.List;

/**
 *
 * @author Elisângela
 */
public interface BeanIF {
    
    
    void salvar();
    
    void atualizar();
    
    void remover();
    
    List<Identificavel> buscarTodos();
    
}
