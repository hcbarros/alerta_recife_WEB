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
@Table(name = "TB_COORDENADA")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Coordenada.RecuperarPorPontoX",
                    query = "SELECT c FROM Coordenada c WHERE c.pontoX = ?1"
            ),
            @NamedQuery(
                    name = "Coordenada.RecuperarPorPontoY",
                    query = "SELECT c FROM Coordenada c WHERE c.pontoY = ?1"
            ),            
            @NamedQuery(
                    name = "Coordenada.RecuperarCoordenadas",
                    query = "SELECT c FROM Coordenada c ORDER BY c.id"
            )              
        }
)
@Access(AccessType.FIELD)
public class Coordenada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //@NotNull
    @OneToOne(mappedBy = "coordenada")
    private Endereco endereco;

    @NotNull
    @Column(name = "PONTO_X")
    double pontoX; // 12 caracteres

    @NotNull
    @Column(name = "PONTO_Y")
    double pontoY; // 12 caracteres

    public Coordenada() {

    }

    public Coordenada(Long id, Endereco endereco, double pontoX, double pontoY) {
        this.id = id;
        this.endereco = endereco;
        this.pontoX = pontoX;
        this.pontoY = pontoY;
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
        // this.endereco.setCoordenada(this);
        // Quando a linha está descomentada, dá erro no t01 de EnderecoCRUDTest
    }
    
    public double getPontoX() {
        return pontoX;
    }

    public void setPontoX(double pontoX) {
        this.pontoX = pontoX;
    }

    public double getPontoY() {
        return pontoY;
    }

    public void setPontoY(double pontoY) {
        this.pontoY = pontoY;
    }

}
