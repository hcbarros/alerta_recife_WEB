/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="chamado")
@RequestScoped
public class Chamado {
    
    private long processo;
    private String data;
    private String descricao;
    private String bairro;
    private String endereco;
    private String situacao;
    private String tipo;
    
    
    public Chamado () {}
    
    public Chamado(long processo, String data, String descricao, String bairro, String endereco, String situacao, String tipo) {
        
        this.processo = processo;
        setData(data);
        this.descricao = descricao;
        this.bairro = bairro;
        this.endereco = endereco;
        this.situacao = situacao;
        this.tipo = tipo;
    }
    
    
    public long getProcesso() {
        return processo;
    }
    
    public void setProcesso(long processo) {
        this.processo = processo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try{
            Date date = dt.parse(data);
            dt.applyPattern("dd/MM/yyyy");
            this.data = dt.format(date);
        }catch(ParseException | NullPointerException e) {
            this.data = null;
        }       
    }
    
    public String getBairro(){
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getSituacao(){
        return situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
       
}
