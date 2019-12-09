/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import ifpe.recife.tads.alerta_recife.Contato;
import ifpe.recife.tads.alerta_recife.Telefone;
import ifpe.recife.tads.alerta_recife.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="Contato")
@RequestScoped
public class CadastroContato {
        
    @EJB
    private ContatoServico contatoServico; 
    private String descricao;
    private long telefone;
    private static List<Contato> lista = null;
       
    private CadastroEndereco endereco;    
    
    
    public String cadastrar() {
               
        Contato contato = new Contato();
        contato.setDescricao(descricao);
        contato.setNumero(Long.toString(telefone));
        contatoServico.persistir(contato);  
        CadastroEndereco.resp = "Contato cadastrado com sucesso!";

        return "telefone";
    }
        
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public long getTelefone() {
        return telefone;
    }
    
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public List<Contato> getLista(){
        lista = contatoServico.consultarContatos();
        return lista;
    }
    
    public void setLista() {
        lista = contatoServico.consultarContatos();
    }   
}
