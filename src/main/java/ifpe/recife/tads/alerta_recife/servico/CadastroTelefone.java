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
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="Telefone")
@RequestScoped
public class CadastroTelefone {
        
    @EJB
    private TelefoneServico telefoneServico; 
    private int ddd;
    private long telefone;
   
    private CadastroEndereco endereco;    
    
    
    public String cadastrar() {
               
        Telefone tel = new Telefone();
        tel.setDdd(Integer.toString(ddd));
        tel.setNumero(Long.toString(telefone));
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("logado");
        tel.setUsuario(usuarioLogado);        
        telefoneServico.persistir(tel);       
        CadastroEndereco.resp = "Telefone cadastrado com sucesso!";

        return "telefone";
    }
     
        
    public int getDdd() {
        return ddd;
    }
    
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
    
    public long getTelefone() {
        return telefone;
    }
    
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
