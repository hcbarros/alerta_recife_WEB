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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;


@ManagedBean(name="Endereco")
@RequestScoped
public class CadastroEndereco implements Serializable {
        
    @EJB
    private EnderecoServico enderecoServico; 
    private String pontoX = null;
    private String pontoY = null;
    private String cidade = null;
    private String bairro = null;
    private String rua = null;
    private String numero = null;    
    private String CEP = null;
    private String risco = null;
    private static List<Endereco> lista = null;
    @EJB
    private SolicitacaoServico solicitacaoServico; 
    private static Endereco selected = null; 
    private static Usuario usuario = null;
    private String tipo = null;
    private String descricao = null;
    private UIComponent mybutton;
    protected static String resp = "";
    
    
    
    public String cadastrar() {
                
        lista = enderecoServico.recuperarEnderecos();
                
        Coordenada coordenada = new Coordenada();
        Endereco endereco = new Endereco();
        PontoDeRisco ponto_risco = new PontoDeRisco();
            coordenada.setPontoX(Double.parseDouble(pontoX));
            coordenada.setPontoY(Double.parseDouble(pontoY));
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setCEP(CEP);
        ponto_risco.setTipoDeRisco(Integer.parseInt(risco));
        endereco.setPontoDeRisco(ponto_risco);
        endereco.setCoordenada(coordenada);                
        
        enderecoServico.persistir(endereco);    
        resp = "Dados cadastrados com sucesso!";
        
        return "cadastro";
    }
      
     
    public String solicitarServico() {
               
        
        FacesContext context = FacesContext.getCurrentInstance();
        Solicitacao sol = new Solicitacao();
        sol.setDescricao(descricao);
        if(selected == null) {
        context.addMessage(mybutton.getClientId(context), 
                                  new FacesMessage("","Selecione uma área de risco!"));
                                  return "servico";
        }
        sol.setEndereco(selected);
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
        resp = "Dados cadastrados com sucesso!";
        
        return "retornoservico";
    }
     
       
    public Endereco getSelected(){
        return selected;
    }
    
    public void setSelected(Endereco selected) {
        this.selected = selected;
    }
    
    public String getPontoX() {
        return pontoX;
    }
    
    public String getPontoY() {
        return pontoY;
    }
    
    public void setPontoY(String pontoY) {
        this.pontoY = pontoY;
    }
    
    public void setPontoX(String pontoX) {
        this.pontoX = pontoX;
    }

    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getCEP() {
        return CEP;
    }
    
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    public String getRisco() {
        return risco;
    }
    
    public void setRisco(String risco) {
        this.risco = risco;
    }
    
    public List<Endereco> getLista() {
        lista = enderecoServico.recuperarEnderecos();
        return lista;
    }
        
    public void setLista() {
        lista = enderecoServico.recuperarEnderecos();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public UIComponent getMybutton() {
        return mybutton;
    }
    
    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    
    public String getResp() {
        return resp;
    }
    
    public void setResp(String resp) {
        this.resp = resp;
    }
    
}
