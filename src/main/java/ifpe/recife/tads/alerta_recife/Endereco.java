package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ENDERECO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Endereco.RecuperarEnderecos",
                    query = "SELECT e FROM Endereco e ORDER BY e.id"
            )
            ,
            @NamedQuery(
                    name = "Endereco.RecuperarPorRua",
                    query = "SELECT e FROM Endereco e WHERE e.rua = ?1"
            )
            ,
            @NamedQuery(
                    name = "Endereco.RecuperarPorNumero",
                    query = "SELECT e FROM Endereco e WHERE e.numero = :numero"
            )
            ,
            @NamedQuery(
                    name = "Endereco.RecuperarPorBairro",
                    query = "SELECT e FROM Endereco e WHERE e.bairro = ?1"
            )
            ,
            @NamedQuery(
                    name = "Endereco.RecuperarPorBairroAprox",
                    query = "SELECT e FROM Endereco e WHERE e.bairro LIKE :bairro ORDER BY e.bairro"
            )
            ,
            @NamedQuery(
                    name = "Endereco.RecuperarPorRuaOrdenando",
                    query = "SELECT e FROM Endereco e WHERE e.rua = :rua ORDER BY e.rua ASC"
            )
        }
)
@Access(AccessType.FIELD)
public class Endereco extends Entidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ID_COORDENADA", referencedColumnName = "ID")
    private Coordenada coordenada;

    @NotNull
    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private PontoDeRisco pontoDeRisco;

    @NotNull
    @Column(name = "RUA", length = 100)
    private String rua;

    @NotNull
    @Column(name = "NUMERO", length = 10)
    private String numero;

    @NotNull
    @Column(name = "BAIRRO", length = 100)
    private String bairro;

    @NotNull
    @Column(name = "CIDADE", length = 100)
    private String cidade;
    
    @Column(name = "CEP", length = 10)
    private String CEP;

    @OneToMany(mappedBy = "endereco",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitacao> solicitacao;

    public Endereco() {
        this.solicitacao = new ArrayList<>();
        this.pontoDeRisco = new PontoDeRisco();
    }

    public Endereco(Long id, Coordenada coordenada, PontoDeRisco pontoDeRisco, String rua, String numero, String bairro, String cidade, String CEP, List<Solicitacao> solicitacao) {
        this.id = id;
        this.coordenada = coordenada;
        this.pontoDeRisco = new PontoDeRisco();
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.solicitacao = new ArrayList<>();
    }

    public PontoDeRisco getPontoDeRisco() {
        return pontoDeRisco;
    }

    public void setPontoDeRisco(PontoDeRisco pontoDeRisco) {
        this.pontoDeRisco = pontoDeRisco;
        this.pontoDeRisco.setEndereco(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
        this.coordenada.setEndereco(this);
    }

    public String getCEP() {
        return CEP;
    }
    
    public void setCEP(String CEP) {
        this.CEP = CEP;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean addSolicitacao(Solicitacao sol) {
        sol.setEndereco(this);
        return solicitacao.add(sol);
    }
    
    public List<Solicitacao> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Solicitacao> solicitacao) {
        this.solicitacao = solicitacao;
    }

}
