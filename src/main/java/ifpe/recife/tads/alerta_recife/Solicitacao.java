package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_SOLICITACAO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Solicitacao.RecuperarPorDescricao",
                    query = "SELECT s FROM Solicitacao s WHERE s.descricao LIKE :descricao ORDER BY s.descricao"
            )
            ,
            @NamedQuery(
                    name = "Solicitacao.RecuperarPorTipo",
                    query = "SELECT s FROM Solicitacao s WHERE s.tipoDeSolicitacao = ?1 ORDER BY s.descricao"
            )
            ,
            @NamedQuery(
                    name = "Solicitacao.RecuperarNaoAtendidos",
                    query = "SELECT s FROM Solicitacao s WHERE s.dataConclusao IS NULL"
            ),
            @NamedQuery(
                    name = "Solicitacao.RecuperarPorUsuario",
                    query = "SELECT s FROM Solicitacao s WHERE s.usuario IN (SELECT u FROM Usuario u WHERE u.email = ?1)"
            )    
        }
)
@NamedNativeQueries(
        {
            @NamedNativeQuery(
                    name = "Solicitacao.RecuperarPorIdSQL",
                    query = "SELECT * FROM TB_SOLICITACAO WHERE ID = ?",
                    resultClass = Solicitacao.class
            )
            ,
            @NamedNativeQuery(
                    name = "Solicitacao.RecuperarPorDescricaoSQL",
                    query = "SELECT * FROM TB_SOLICITACAO WHERE DESCRICAO = ? ORDER BY DESCRICAO",
                    resultClass = Solicitacao.class
            )
            ,
            @NamedNativeQuery(
                    name = "Solicitacao.RecuperarPorTipoSQL",
                    query = "SELECT * FROM TB_SOLICITACAO WHERE TIPO_SOLICITACAO = ? ORDER BY DESCRICAO",
                    resultClass = Solicitacao.class
            )
        }
)
@Access(AccessType.FIELD)
public class Solicitacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @NotNull(message = "{ifpe.recife.tads.alerta_recife.Solicitacao.descricao_required}")
    @Size(min = 1, max = 220,
            message = "{ifpe.recife.tads.alerta_recife.Solicitacao.descricao_tamanho}")
    @Pattern(regexp = "^[A-Za-z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s]+$",
            message = "{ifpe.recife.tads.alerta_recife.Solicitacao.descricao_caracter}")
    @Column(name = "DESCRICAO", length = 220)
    private String descricao;

    @NotNull(message = "{ifpe.recife.tads.alerta_recife.Solicitacao.tipo_required}")
    @Column(name = "TIPO_SOLICITACAO")
    private int tipoDeSolicitacao;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID")
    private Endereco endereco;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private Usuario usuario;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    @Past
    @Column(name = "DATA_SOLICITACAO")
    private Date dataSolicitacao;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "DATA_CONCLUSAO")
    private Date dataConclusao;

    public Solicitacao() {
    }

    public Solicitacao(Long id, String descricao, int tipoDeSolicitacao, Endereco endereco, Usuario usuario, Date dataSolicitacao, Date dataConclusao) {
        this.id = id;
        this.descricao = descricao;
        this.tipoDeSolicitacao = tipoDeSolicitacao;
        this.endereco = endereco;
        this.usuario = usuario;
        this.dataSolicitacao = dataSolicitacao;
        this.dataConclusao = dataConclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoDeSolicitacao() {
        return tipoDeSolicitacao;
    }

    public void setTipoDeSolicitacao(int tipoDeSolicitacao) {
        this.tipoDeSolicitacao = tipoDeSolicitacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

}
