/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="Indicador")
@RequestScoped
public class IndicadorTempo implements Serializable {
        
    private static List<Tempo> previsao = null;
    private static String atualizacao = "";
    private static String temp = "";
    private static String condicao = "";
    private static String umidade = "";
    private static String vento = "";  
    private static String imagem = "";
    
     
    public List<Tempo> getPrevisao () {
                       
         previsao = new ArrayList<>();
        
         String url = "http://servicos.cptec.inpe.br/XML/cidade/239/previsao.xml";
        try {
            URL myurl = new URL(url);
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
            con.setDoOutput(true);

            con.setRequestProperty("Content-Type", "application/xml");
            //con.setRequestProperty("Accept-Charset", "UTF-8, iso-8859-1;q=0.5");
            con.setRequestMethod("GET");
            
            String response = null;
            StringBuilder sb = new StringBuilder();  

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));  

            String line = null;
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }
            br.close(); 
            response = sb.toString();  
               
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(response));
            Document doc = db.parse(is);
            Element element = doc.getDocumentElement();
            NodeList nodes = element.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                if(nodes.item(i).getNodeName().equals("previsao")) {
                    Node dia = nodes.item(i).getFirstChild();
                    Node weather = dia.getNextSibling();
                    Node tempMax = weather.getNextSibling();
                    Node tempMin = tempMax.getNextSibling();
                    
                    previsao.add(new Tempo(dia.getTextContent(),weather.getTextContent(),
                            tempMax.getTextContent(),tempMin.getTextContent()));                            
                }
            }
            return previsao;
            
        } catch(IOException | ParserConfigurationException | SAXException e) {
                e.printStackTrace();
          } 
        
        return previsao;
    }
        
    
    public void condicoesAtuais() {
        
        String url = "http://servicos.cptec.inpe.br/XML/estacao/SBRF/condicoesAtuais.xml";
        try {
            URL myurl = new URL(url);
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
            con.setDoOutput(true);

            con.setRequestProperty("Content-Type", "application/xml");
            //con.setRequestProperty("Accept-Charset", "UTF-8, iso-8859-1;q=0.5");
            con.setRequestMethod("GET");
            
            String response = null;
            StringBuilder sb = new StringBuilder();  

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"ISO-8859-1"));  

            String line = null;
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }
            br.close(); 
            response = sb.toString();  
               
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(response));
            Document doc = db.parse(is);
            Element element = doc.getDocumentElement();
            NodeList nodes = element.getChildNodes();
            
            for (int i = 0; i < nodes.getLength(); i++) {
                if(nodes.item(i).getNodeName().equals("atualizacao"))
                    atualizacao = nodes.item(i).getTextContent();
                if(nodes.item(i).getNodeName().equals("temperatura"))
                    temp = nodes.item(i).getTextContent();
                if(nodes.item(i).getNodeName().equals("tempo")) { 
                   String t = nodes.item(i).getTextContent();
                   if(t.equals("ec") || t.equals("ci") || t.equals("pp") || t.equals("pp")
                           || t.equals("cm") || t.equals("pt") || t.equals("pm") 
                           || t.equals("np") || t.equals("pc") || t.equals("cv")
                           || t.equals("psc") || t.equals("pcm") || t.equals("pct")
                           || t.equals("npt") || t.equals("npm") || t.equals("ct")
                           || t.equals("npp") || t.equals("ppt") || t.equals("ppm")
                           || t.equals("nct") || t.equals("ncm")) imagem = "pancadasChuva.png";
                   if(t.equals("c") || t.equals("ch") || t.equals("e") || t.equals("g") 
                           || t.equals("nv") || t.equals("ne") || t.equals("vn"))
                       imagem = "chuva.png";
                   if(t.equals("in") || t.equals("pn") || t.equals("n") || t.equals("nd")) 
                       imagem = "nublado.png";
                   if(t.equals("pnt") || t.equals("pcn") || t.equals("ncn") || t.equals("ppn")) 
                       imagem = "nubladoNoite.png";
                   if(t.equals("ps") || t.equals("cl")) imagem = "sol.png";
                   if(t.equals("t")) imagem = "tempestade.png";
                   
                }
                if(nodes.item(i).getNodeName().equals("tempo_desc"))
                    condicao = nodes.item(i).getTextContent();
                if(nodes.item(i).getNodeName().equals("umidade"))
                    umidade = nodes.item(i).getTextContent();
                if(nodes.item(i).getNodeName().equals("vento_int"))
                    vento = nodes.item(i).getTextContent();
            }
            
        } catch(IOException | ParserConfigurationException | SAXException e) {
                e.printStackTrace();
          }    
        
    }
    
    
    
    public void setTempo() {
        previsao = new ArrayList<>();
    }
    
    public String getAtualizacao() {
        return atualizacao;
    }
    
    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    public String getTemp() {
        return temp;
    }
    
    public void setTemp(String temp) {
        this.temp = temp; 
    }
    
    public String getCondicao() {
        return condicao;
    }
    
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
     
    public String getUmidade() {
        return umidade;
    }
    
    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }
    
    public String getVento() {
        return vento;
    }
    
    public void setVento(String vento) {
        this.vento = vento;
    }
    
    public String getImagem() {
        return imagem;
    }
    
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
}
