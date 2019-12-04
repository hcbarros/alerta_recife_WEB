/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import ifpe.recife.tads.alerta_recife.BancoDados;
import ifpe.recife.tads.alerta_recife.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="Login")
@ApplicationScoped
public class Login {
        
    @EJB
    private UsuarioServico usuarioServico; 
    private static String email = null;
    private static String senha = null;
    private static Usuario user = null;
    private static String banco = null;
    private static final String MAP_KEY = "https://www.bing.com/api/maps/mapcontrol?key=AvltJznm3FCdzkLGAv5FejAGp7JPsdfDsn7Xi-pYp-q1osNmljdeo9HPZkq9SjC8&callback=loadMapScenario";
    private UIComponent mybutton;
        
    
    public String fazerLogin() {
                
        FacesContext context = FacesContext.getCurrentInstance();
        user = usuarioServico.consultarPorEmail(email);
                               
         try {
              String gRecaptchaResponse = context.
		getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
               boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
               
              if(user != null) {
                    if(user.getSenha().equals(senha)) {
                             
                        
                         if(verify){
                           HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                           sessao.setAttribute("logado", user);
                           return "encontrado";  
                         }
                         else{
                             context.addMessage(mybutton.getClientId(context), 
                                  new FacesMessage("","Selecione o captcha!"));
                                  return "invalido";
                         }
                        
                    }
                    else {
                        context.addMessage(mybutton.getClientId(context), 
                                new FacesMessage("","Login ou senha invalidos!"));
                        return "invalido";
                    }
              }   
        
              else {
                  context.addMessage(mybutton.getClientId(context), 
                        new FacesMessage("","Login ou senha invalidos!"));
                  return "invalido";
              }  
               
              
         } catch (Exception e) {
             context.addMessage(mybutton.getClientId(context), 
                        new FacesMessage("", e.toString()));
                        return "invalido";
         }
        
            
        
        
    }
       
    
    public void preencherBanco(){
        
        if(banco == null) banco = BancoDados.inserirDados();
    }  
    
    public String getSenha() {
        return senha;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Usuario getUser() {
        return user;
    }
    
    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public String getMAP_KEY() {
        return MAP_KEY;
    }
    
    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public UIComponent getMybutton() {
        return mybutton;
    }
    
}
