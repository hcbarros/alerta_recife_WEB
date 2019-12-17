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

@ManagedBean(name="lona")
@RequestScoped
public class Lona {
    
    private long processo;
    private String situacao;
    private String data;
    private int metragem;
    private String justificativa;
    
    
    public Lona () {}
    
    public Lona(long processo, String situacao, String data, int metragem, String justificativa) {
        
        this.processo = processo;
        this.situacao = situacao;
        setData(data);
        this.metragem = metragem;
        this.justificativa = justificativa;
    }
    
    
    public long getProcesso() {
        return processo;
    }
    
    public void setProcesso(long processo) {
        this.processo = processo;
    }
    
    public String getSituacao() {
        return situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
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
    
    public int getMetragem(){
        return metragem;
    }
    
    public void setMetragem(int metragem) {
        this.metragem = metragem;
    }
    
    public String getJustificativa(){
        return justificativa;
    }
    
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
       
}
