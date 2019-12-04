package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PONTO_RISCO")
@NamedQueries(
        {            
            @NamedQuery(
                    name = "PontoDeRisco.RecuperarPorTipoDeRisco",
                    query = "SELECT p FROM PontoDeRisco p WHERE p.tipoDeRisco = ?1"
            ),
            @NamedQuery(
                    name = "PontoDeRisco.RecuperarPontosDeRisco",
                    query = "SELECT p FROM PontoDeRisco p ORDER BY p.id"
            )    
             ,
            @NamedQuery(
                    name = "PontoDeRisco.RecuperarPorEnderecoRua",
                    query = "SELECT p FROM PontoDeRisco p WHERE p.endereco IN (SELECT e FROM Endereco e WHERE e.rua = ?1)"
            )
        }
)
@Access(AccessType.FIELD)
public class PontoDeRisco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID")
    private Endereco endereco;
    
    @NotNull
    @Column(name = "TIPO_RISCO")
    private int tipoDeRisco;

    public PontoDeRisco() {
        
    }

    public PontoDeRisco(Long id, Endereco endereco, int tipoDeRisco) {
        this.id = id;
        this.endereco = endereco;
        this.tipoDeRisco = tipoDeRisco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getTipoDeRisco() {
        return tipoDeRisco;
    }

    public void setTipoDeRisco(int tipoDeRisco) {
        this.tipoDeRisco = tipoDeRisco;
    }
    
}
