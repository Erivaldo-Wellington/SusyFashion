package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.dao.LoginDaoIF;
import br.com.getup.susyFashion.modelo.Login;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;


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
    
    @Transactional
    public void cadastro(){
        loginDaoIF.cadastrarLogin(login);
        
    }
    
    public void logar() throws IOException{
        
        if(estaLogado()){
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/SusyFashion/index.xhtml");
            
        }else FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/SusyFashion/login.xhtml");
        
    }
    
    public void tempoEncerrado() throws IOException {
        sair();
        
    }
    
    public void sair() throws IOException{
        usuarioLogado=false;
        login= null;
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/SusyFashion/login.xhtml");
    }
    
    private boolean estaLogado(){
        Login loginAux = loginDaoIF.buscarPorLogin(login.getUsuario(), login.getSenha());
        if(loginAux != null){
            usuarioLogado=true;
            
            return true;
        }else{
            usuarioLogado=false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Senha ou Usuário inválidos", ""));
        }
        return false;
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
