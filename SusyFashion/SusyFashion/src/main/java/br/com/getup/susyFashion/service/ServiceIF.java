/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.modelo.Identificavel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface ServiceIF extends Serializable{
    
    void salvar(Identificavel entidade);
    
    void atualizar(Identificavel entidade);
    
    void remover(Identificavel entidade);
    
    Identificavel buscarPorId(Long id);
    
    List<Identificavel> buscarTodos();
    
    
}
