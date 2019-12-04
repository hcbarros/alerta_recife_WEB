/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import ifpe.recife.tads.alerta_recife.Telefone;
import ifpe.recife.tads.alerta_recife.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="Telefone")
@RequestScoped
public class CadastroTelefone {
        
    @EJB
    private TelefoneServico telefoneServico; 
    private String ddd = "";
    private String telefone = "";
        
    
    public void cadastrar() {
               
        Telefone tel = new Telefone();
        tel.setDdd(ddd);
        tel.setNumero(telefone);
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("logado");
        tel.setUsuario(usuarioLogado);        
        telefoneServico.persistir(tel);       
        
    }
     
        
    public String getDdd() {
        return ddd;
    }
    
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
