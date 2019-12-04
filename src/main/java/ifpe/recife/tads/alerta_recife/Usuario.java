package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "TB_USUARIO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Usuario.RecuperarPorEmail",
                    query = "SELECT u FROM Usuario u WHERE u.email = ?1"
            ),
            @NamedQuery(
                    name = "Usuario.RecuperarAtivos",
                    query = "SELECT u FROM Usuario u WHERE u.habilitado = :habilitado ORDER BY u.primeiroNome"
            ),
            @NamedQuery(
                    name = "Usuario.RecuperarPorNome",
                    query = "SELECT u FROM Usuario u WHERE u.primeiroNome LIKE ?1 OR u.ultimoNome LIKE ?1"
            ),
            @NamedQuery(
                    name = "Usuario.RecuperarPorPrimeiroNome",
                    query = "SELECT u FROM Usuario u WHERE u.primeiroNome LIKE ?1"
            ),
            @NamedQuery(
                    name = "Usuario.RecuperarPorUltimoNome",
                    query = "SELECT u FROM Usuario u WHERE u.ultimoNome LIKE ?1"
            ),
            @NamedQuery(
                    name = "Usuario.RecuperarPorId",
                    query = "SELECT u FROM Usuario u WHERE u.id = ?1"
            )
                 
        }
)
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.JOINED)
@ManagedBean(name="usuario")
@RequestScoped
public class Usuario extends Entidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Email
    @Column(name = "EMAIL", unique = true, length = 100)
    private String email;

    @NotNull
    @Column(name = "SENHA", length = 200)
    private String senha;

    @NotNull
    @Column(name = "PRIMEIRO_NOME", length = 50)
    private String primeiroNome;

    @NotNull
    @Column(name = "ULTIMO_NOME", length = 50)
    private String ultimoNome;

    @OneToMany(mappedBy = "usuario", 
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "TB_USUARIO_TELEFONE", joinColumns
            = {
                @JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns
            = {
                @JoinColumn(name = "ID_TELEFONE")})
    private List<Telefone> telefones;

    @NotNull
    @Column(name = "HABILITADO")
    private boolean habilitado;
    
    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitacao> solicitacao;

    public Usuario() {
        this.telefones = new ArrayList<>();
        this.solicitacao = new ArrayList<>();
    }
    
    public Usuario(Long id, String email, String senha, String primeiroNome, String ultimoNome, List<Telefone> telefones, boolean habilitado, List<Solicitacao> solicitacao) {
        this.telefones = new ArrayList<>();
        this.solicitacao = new ArrayList<>();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.habilitado = habilitado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    
    public boolean addTelefone(Telefone telefone) {
        telefone.setUsuario(this);
        return telefones.add(telefone);
    }
    
    public boolean addSolicitacao(Solicitacao solicita) {
        solicita.setUsuario(this);
        return solicitacao.add(solicita);
    }
        
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Solicitacao> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Solicitacao> solicitacao) {
        this.solicitacao = solicitacao;
    }

}
