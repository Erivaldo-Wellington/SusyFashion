package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.dao.LoginDaoIF;
import br.com.getup.susyFashion.modelo.Login;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author MarkusPatriota
 */
@Named
@RequestScoped
public class LoginBean implements Serializable{
    
    @Inject
    private LoginDaoIF loginDaoIF;
       
    private Login login;
    
    private static boolean usuarioLogado;
    
    public LoginBean() {
        login=new Login();
    }
    
    public void cadastro(){
        loginDaoIF.cadastrarLogin(login);
        
    }
    
    public String logar(){
        
        if(estaLogado()){
            return "/index.xhtml";
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Senha ou Usuario inválidos", ""));
            usuarioLogado=false;
        }
        return "/login.xhtml";
    }
    
    private boolean estaLogado(){
        Login loginAux = loginDaoIF.buscarPorLogin(login.getUsuario(), login.getSenha());
        if(loginAux != null){
            usuarioLogado=true;
            
            //System.out.println("Usuario:"+loginAux.getUsuario());
            return true;
        }
        return false;
    }
    public String sair(){
        login= null;
        usuarioLogado=false;
        return "/login.xhtml";
    }
    
    public LoginDaoIF getLoginDaoIF() {
        return loginDaoIF;
    }
    
    public void setLoginDaoIF(LoginDaoIF loginDaoIF) {
        this.loginDaoIF = loginDaoIF;
    }
        
    public Login getLogin() {
        return login;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }
    
    public static boolean isUsuarioLogado() {
        return usuarioLogado;
    }
    
}
