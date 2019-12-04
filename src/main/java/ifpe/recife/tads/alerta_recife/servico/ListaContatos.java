/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import ifpe.recife.tads.alerta_recife.Contato;
import ifpe.recife.tads.alerta_recife.Coordenada;
import ifpe.recife.tads.alerta_recife.Endereco;
import ifpe.recife.tads.alerta_recife.PontoDeRisco;
import ifpe.recife.tads.alerta_recife.Solicitacao;
import ifpe.recife.tads.alerta_recife.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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


@ManagedBean(name="Contato")
@RequestScoped
public class ListaContatos {
        
    @EJB
    private ContatoServico contatoServico; 
    private static List<Contato> lista = null;
         
    public List<Contato> getLista(){
        lista = contatoServico.consultarContatos();
        return lista;
    }
    
    public void setLista(List<Contato> lista) {
        this.lista = lista;
    }       
    
}
