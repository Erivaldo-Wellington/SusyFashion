/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.getup.susyFashion.service;

import br.com.getup.susyFashion.modelo.Cliente;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface ClienteServiceIF extends ServiceIF{
    
    List<Cliente> findByNameLike(String query);
}
