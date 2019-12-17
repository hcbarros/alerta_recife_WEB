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

@ManagedBean(name="vistoria")
@RequestScoped
public class Vistoria {
    
    private long processo;
    private String avaliador;
    private String data;
    private String risco;
    private String local;
    
    
    public Vistoria () {}
    
    public Vistoria(long processo, String avaliador, String data, String risco, String local) {
        
        this.processo = processo;
        this.avaliador = avaliador;
        setData(data);
        this.risco = risco;
        this.local = local;
    }
    
    
    public long getProcesso() {
        return processo;
    }
    
    public void setProcesso(long processo) {
        this.processo = processo;
    }
    
    public String getAvaliador() {
        return avaliador;
    }
    
    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
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
    
    public String getRisco(){
        return risco;
    }
    
    public void setRisco(String risco) {
        this.risco = risco;
    }
    
    public String getLocal(){
        return local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
       
}
