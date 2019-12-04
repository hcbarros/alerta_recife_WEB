package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CONTATO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Contato.RecuperarPorDescricao",
                    query = "SELECT c FROM Contato c WHERE c.descricao LIKE :descricao"
            )
            ,
            @NamedQuery(
                    name = "Contato.RecuperarContatos",
                    query = "SELECT c FROM Contato c ORDER BY c.descricao"
            )
            ,
            @NamedQuery(
                    name = "Contato.RecuperarPorNumero",
                    query = "SELECT c FROM Contato c WHERE c.numero = :numero"
            )
        }
)
@Access(AccessType.FIELD)
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "DESCRICAO", length = 100)
    private String descricao;
    
    @NotNull
    @Column(name = "NUMERO", length = 20)
    private String numero;
    
    public Contato(){
        
    }
    
    public Contato(Long id, String descricao, String numero) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
