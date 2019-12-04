/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import ifpe.recife.tads.alerta_recife.Coordenada;
import ifpe.recife.tads.alerta_recife.Endereco;
import ifpe.recife.tads.alerta_recife.PontoDeRisco;
import ifpe.recife.tads.alerta_recife.Solicitacao;
import ifpe.recife.tads.alerta_recife.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="Solicitacao")
@RequestScoped
public class CadastroSolicitacao {
        
    @EJB
    private SolicitacaoServico solicitacaoServico; 
    private static Endereco endereco = null;
    private static Usuario usuario = null;
    private static String tipo = null;
    private static String descricao = null;
    
    
    public void cadastrar() {
               
        Solicitacao sol = new Solicitacao();
        sol.setDescricao(descricao);
        Endereco endereco = new Endereco();
        endereco.setId(new Long(1));
        sol.setEndereco(endereco);
        sol.setTipoDeSolicitacao(Integer.parseInt(tipo));
        
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("logado");
        sol.setUsuario(usuarioLogado);
            
            Calendar c = Calendar.getInstance();
            int ano = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);
            int hora = c.get(Calendar.HOUR_OF_DAY - 1);
            int min = c.get(Calendar.MINUTE);
                c.set(ano, mes, dia, hora, min);
        sol.setDataSolicitacao(c.getTime());
        solicitacaoServico.persistir(sol);       
    }
     

        
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getTipo() {        
        return tipo;
    }
        
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
