package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_TELEFONE")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Telefone.RecuperarTelefones",
                    query = "SELECT t FROM Telefone t"
            ),
            @NamedQuery(
                    name = "Telefone.RecuperarPorNumero",
                    query = "SELECT t FROM Telefone t WHERE t.numero = :numero"
            ),
            @NamedQuery(
                    name = "Telefone.RecuperarPorUsuario",
                    query = "SELECT t FROM Telefone t WHERE t.usuario IN (SELECT u FROM Usuario u WHERE u.email = ?1)"
            )    
        }
)
@Access(AccessType.FIELD)
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @NotNull
    @Column(name = "NUMERO")
    private String numero;

    @NotNull
    @Column(name = "DDD")
    private String ddd;

    public Telefone() {

    }

    public Telefone(Long id, Usuario usuario, String numero, String ddd) {
        this.id = id;
        this.usuario = usuario;
        this.numero = numero;
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

}
