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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;


@ManagedBean(name="api")
@RequestScoped
public class APIDefesaCivil implements Serializable {
        
    private static List<Lona> lonas = null;
    private static List<Vistoria> vistorias = null;
    private static List<Chamado> solicitacoes = null;
    private static int total = 0;
    private static int posicao = 0;
    
    
    public String buscarSolicitacoes() {
                      
         solicitacoes = new ArrayList<>();  

         posicao = posicao <= 0 ? 0 : posicao;                        

         String url = "http://dados.recife.pe.gov.br/api/3/action/datastore_search?offset="+posicao+"&limit=10&resource_id=fa35d810-b291-4e74-9282-3c4db1aca312";
        
            String response = null;
        
            JsonArray j = obterDados(url);
                                       
            for(int i = 0; i < j.size(); i++) {
                
                JsonObject jsonObject = j.getJsonObject(i);
                
                JsonValue jprocess = jsonObject.get("processo_numero");
                long process = Long.parseLong(jprocess.toString());

                boolean nulo = jsonObject.isNull("solicitacao_data");
                String data = "";
                if(!nulo) data = jsonObject.getString("solicitacao_data");
                
                String descricao = jsonObject.getString("solicitacao_descricao");
                String bairro = jsonObject.getString("solicitacao_bairro");
                String endereco = jsonObject.getString("solicitacao_endereco");
                String situacao = jsonObject.getString("processo_situacao");
                String tipo = jsonObject.getString("processo_solicitacao");    
                
                solicitacoes.add(new Chamado(process,data,descricao,bairro,endereco,situacao,tipo));
            }
                       
            return "solicitacoes";
            
    }
    
    
    public String buscarVistorias() {
                      
         vistorias = new ArrayList<>();  

         posicao = posicao <= 0 ? 0 : posicao;
                 
         String url = "http://dados.recife.pe.gov.br/api/3/action/datastore_search?offset="+posicao+"&limit=10&resource_id=bb4b8cdb-122b-491a-80f7-b028b66108e1";
        
            String response = null;
        
            JsonArray j = obterDados(url);
                                       
            for(int i = 0; i < j.size(); i++) {
                
                JsonObject jsonObject = j.getJsonObject(i);
                
                String avaliador = jsonObject.getString("avaliador");

                boolean nulo = jsonObject.isNull("vistoria_data");
                String data = "";
                if(!nulo) data = jsonObject.getString("vistoria_data");
                
                String risco = jsonObject.getString("vistoria_risco");
                String local = jsonObject.getString("vistoria_localidade");
                                
                JsonValue jprocess = jsonObject.get("processo_numero");
                long process = Long.parseLong(jprocess.toString());

                vistorias.add(new Vistoria(process,avaliador,data,risco,local));
            }
                       
            return "vistorias";
            
    }
    
    
    public String buscarLonas() {
                      
         lonas = new ArrayList<>();  

         posicao = posicao <= 0 ? 0 : posicao;
                  
         String url = "http://dados.recife.pe.gov.br/api/3/action/datastore_search?offset="+posicao+"&limit=10&resource_id=48dd7535-329c-4a6a-bb2d-f26ebb1ab531";
        
            JsonArray j = obterDados(url);
         
            for(int i = 0; i < j.size(); i++) {
                
                JsonObject jsonObject = j.getJsonObject(i);
                
                JsonValue jprocess = jsonObject.get("processo_numero");
                long process = Long.parseLong(jprocess.toString());
                
                String situacao = jsonObject.getString("colocacao_lona_situacao");
                               
                boolean nulo = jsonObject.isNull("colocacao_lona_data");
                String data = "";
                if(!nulo) data = jsonObject.getString("colocacao_lona_data");
                
                String just = jsonObject.getString("colocacao_lona_justificativa");
                int metragem = jsonObject.getInt("colocacao_lona_metragem");

                lonas.add(new Lona(process,situacao,data,metragem,just));
            }
                       
            return "lonas";
            
    }
          
    
    public JsonArray obterDados(String url) {
        
        String response = null;
        
        try {
            URL myurl = new URL(url);
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
            con.setDoOutput(true);

            con.setRequestProperty("Content-Type", "application/json");
            //con.setRequestProperty("Accept-Charset", "UTF-8, iso-8859-1;q=0.5");
            con.setRequestMethod("GET");
                        
            StringBuilder sb = new StringBuilder();  

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"ISO-8859-1"));    

            String line = null;
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }
            br.close(); 
            response = sb.toString();  
            
            response = utfToIso(response);
        
        } catch(IOException e) {
            e.printStackTrace();
        } 
            
            JsonReader reader = Json.createReader(new StringReader(response));
            JsonObject jsonObject = reader.readObject();
            jsonObject = jsonObject.getJsonObject("result");
            total = jsonObject.getInt("total");
                        
            JsonArray j = jsonObject.getJsonArray("records");

            return j;
    }
          
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    } 
    
    public int getPosicao() {
        return posicao;
    }
    
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
     
    public List<Lona> getLonas() {
        return lonas;
    }
    
    public void setLonas(){
        this.lonas = new ArrayList<>();
    }
    
    public List<Vistoria> getVistorias() {
        return vistorias;
    }
    
    public void setVistorias(List<Vistoria> vistorias) {
        this.vistorias = vistorias;
    }
    
    public List<Chamado> getSolicitacoes() {
        return solicitacoes;
    }
    
    public void setSolicitacoes(List<Chamado> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    public static String utfToIso(String mensagem){
        String retorno = "";
        byte[] iso;
        try {
            iso = new String(mensagem.getBytes(), "UTF-8").getBytes("ISO-8859-1");

            retorno = new String(iso);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }   
    
}
