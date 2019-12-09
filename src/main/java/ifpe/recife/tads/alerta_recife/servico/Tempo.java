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

@ManagedBean(name="tempo")
@RequestScoped
public class Tempo {
    
    private String dia;
    private String tempo;
    private String tempMax;
    private String tempMin;
    
    
    public Tempo () {}
    
    public Tempo(String dia, String tempo, String tempMax, String tempMin) {
        
        setDia(dia);
        setTempo(tempo);
        this.tempMax = tempMax+" °C";
        this.tempMin = tempMin+" °C";
    }
    
    public String getDia() {
        return dia;
    }
    
    public void setDia(String dia) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = dt.parse(dia);
            dt.applyPattern("dd/MM/yyyy");
            this.dia = dt.format(date);
        }catch(ParseException e) {
            System.out.print(e);
        }       
    }
    
    public String getTempo(){
        return tempo;
    }
    
    public void setTempo(String t) {
        
        this.tempo = t.equals("ec") ? "Encoberto com chuvas isoladas" : 
                     t.equals("ci") ? "Chuvas Isoladas" : t.equals("c") ? "Chuva" :
                     t.equals("in") ? "Instável" : 
                     t.equals("pp") ? "Possibilidade de pancadas de chuva" :
                     t.equals("cm") ? "Chuva pela manhã" : t.equals("cn") ? "Chuva à noite" :
                     t.equals("pt") ? "Pancadas de Chuva à Tarde" :
                     t.equals("pm") ? "Pancadas de chuva pela manhã" :
                     t.equals("np") ? "Nublado e pancadas de chuva" :
                     t.equals("pc") ? "Pancadas de Chuva" :
                     t.equals("pn") ? "Parcialmente nublado" : t.equals("cv") ? "Chuvisco" :
                     t.equals("ch") ? "Chuvoso" : t.equals("t") ? "Tempestade" : 
                     t.equals("ps") ? "Predomínio de sol" : t.equals("e") ? "Encoberto" :
                     t.equals("n") ? "Nublado" : t.equals("cl") ? "Céu claro" :
                     t.equals("nv") ? "Nevoeiro" : t.equals("g") ? "Geada" :
                     t.equals("ne") ? "Neve" : t.equals("nd") ? "Não definido" :
                     t.equals("pnt") ? "Pancadas de chuva à noite" :
                     t.equals("psc") ? "Possibilidade de chuva" :
                     t.equals("pcm") ? "Possibilidade de chuva pela manhã" :
                     t.equals("pct") ? "Possibilidade de chuva à tarde" :
                     t.equals("pcn") ? "Possibilidade de chuva à noite" :
                     t.equals("npt") ? "Nublado com pancadas à tarde" :
                     t.equals("npn") ? "Nublado com pancadas à noite" :
                     t.equals("ncn") ? "Nublado com possibilidade de chuva à noite" :
                     t.equals("nct") ? "Nublado com possibilidade de chuva à tarde" :
                     t.equals("ncm") ? "Nublado com possibilidade de chuva pela manhã" :
                     t.equals("npm") ? "Nublado com pancadas pela manhã" :
                     t.equals("npp") ? "Nublado com possibilidade de chuva" :
                     t.equals("vn") ? "Variação de nebulosidade" :
                     t.equals("ct") ? "Chuva à tarde" :
                     t.equals("ppn") ? "Possibilidade de pancadas de chuva à noite" :
                     t.equals("ppt") ? "Possibilidade de pancadas de chuva à tarde" :
                     t.equals("ppm") ? "Possibilidade de pancadas de chuva pela manhã" : "";
    }           
    
    public String getTempMax(){
        return tempMax;
    }
    
    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }
    
    public String getTempMin(){
        return tempMin;
    }
    
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }
    
    
}
