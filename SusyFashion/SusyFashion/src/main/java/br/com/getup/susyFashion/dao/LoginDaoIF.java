package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Login;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MarkusPatriota
 */
@Local
public interface LoginDaoIF {
   
   public void cadastrarLogin(Login login);
   public Login buscarPorLogin(String usuario, String senha);
    
}
