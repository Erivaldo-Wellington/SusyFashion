package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.modelo.Talao;
import br.com.getup.susyFashion.service.ServiceIF;
import br.com.getup.susyFashion.service.TalaoServiceIF;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Elisângela
 */
@Named(value = "talaoBean")
@RequestScoped
public class TalaoBean extends AbstratoBean {

    @Inject
    private TalaoServiceIF talaoServiceIF;

    private SelectItem[] selectItens;

    private List<Talao> listaTalao;

    public TalaoBean() {
    }

    @Override
    public ServiceIF getService() {
        return talaoServiceIF;
    }

    @Override
    public Talao getEntidade() {
        if (entidade == null) {
            entidade = new Talao();
        }
        return (Talao) entidade;
    }

    @Override
    public Identificavel setEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//     public  SelectItem[] getSelectItens() {
//        List<Identificavel> buscarTodos = buscarTodos();
//        
//        selectItens = new SelectItem[buscarTodos.size()];
//        
////        selectItens = (SelectItem[]) buscarTodos.toArray();
//        
//         for (int i = 0; i < buscarTodos.size(); i++) {
//             Identificavel identificavel = buscarTodos.get(i);
//             selectItens[i]= identificavel;
//         }
//
//
//
//        
//        return selectItens;
//    }
//    public List<Identificavel> getListaTalao() {
//        return getService().buscarTodos();
//    }

    /**
     * @return the listaTalao
     */
       public List<Talao> getListaTalao() {
        
        List<Identificavel> buscarTodos = buscarTodos();
        List<Talao> taloesLista = new ArrayList<>();
        for (Identificavel identificavel : buscarTodos) {
            Talao taloesAux = (Talao) identificavel;
            taloesLista.add(taloesAux);
        }
        return taloesLista;
    }
}
