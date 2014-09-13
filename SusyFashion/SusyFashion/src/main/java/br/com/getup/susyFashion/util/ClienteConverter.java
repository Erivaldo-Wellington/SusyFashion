/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.util;

import br.com.getup.susyFashion.modelo.Cliente;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author E.Wellington
 */
@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements Converter, Serializable {

    @Inject
    private ClienteServiceIF daoService;

    public ClienteConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cliente clienteRetorno = null;

        if (value != null) {
            Long id = new Long(value);
            clienteRetorno = (Cliente) daoService.buscarPorId(id);
            System.out.println(clienteRetorno.getNome());
        }
        return clienteRetorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Cliente) {
            Cliente cliente = (Cliente) value;
            return cliente.getId() == null ? null : cliente.getId().toString();
        }

        return "";
    }

}
