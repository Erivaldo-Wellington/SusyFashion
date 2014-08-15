/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.dao;

import com.sun.corba.se.spi.ior.Identifiable;
import java.util.ArrayList;

/**
 *
 * @author E.Wellington
 */
public interface DaoIF {
    
    void criar(Identifiable entidade);
    
    void editar(Identifiable entidade);
    
    void remover(Identifiable entidade);
    
    Identifiable buscarPorId(Long id);
    
    ArrayList<Identifiable> buscarTodos();
    
}
