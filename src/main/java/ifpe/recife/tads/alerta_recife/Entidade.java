package ifpe.recife.tads.alerta_recife;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class Entidade implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @Version // 1 ou 0 o prof nao lembra. A1 tem um numero de versao. Usuario 1  deu update e setou o valor para 2. O usuario 2 nao viu isso e quando for acessar a vresao 1 nao é mais um mas sim 2 (por conta do usuario 1)
    @Column(name = "NUM_VERSAO")
    protected int versao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected int getVersao() {
        return versao;
    }

    protected void setVersao(int versao) {
        this.versao = versao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Entidade)) {
            return false;
        }

        Entidade other = (Entidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[ id=" + id + " ]";
    }
    
}
