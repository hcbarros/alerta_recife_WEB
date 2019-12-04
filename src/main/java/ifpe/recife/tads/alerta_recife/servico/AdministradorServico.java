package ifpe.recife.tads.alerta_recife.servico;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;
import ifpe.recife.tads.alerta_recife.*;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Stateless(name = "ejb/AdministradorServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class AdministradorServico extends Servico<Administrador> {

    @PostConstruct
    public void init() {
        super.setClasse(Administrador.class);
    }
    
    @Override
    public Administrador criar() {
        return new Administrador();
    }
       
    public List<Administrador> consultarAdministradores(@Min(value = 1) int cargo) {
        TypedQuery<Administrador> query
                = entityManager.createNamedQuery("Administrador.RecuperarPorCargoNumero",classe);
        query.setParameter(1, cargo);
        return query.getResultList();
    }
    
    @TransactionAttribute(SUPPORTS) 
    public Administrador consultarPorNome(@NotNull String nome) {
        List<Administrador> lista = super.consultarEntidades(new Object[] {nome}, "Administrador.RecuperarPorNome");
        return lista.isEmpty() ? null : lista.get(0);
    }

    @TransactionAttribute(SUPPORTS) 
    public Administrador consultarPorMatricula(@NotNull String matricula) {
        List<Administrador> lista = super.consultarEntidades(new Object[] {matricula}, "Administrador.RecuperarPorMatricula");
        return lista.isEmpty() ? null : lista.get(0);
    }
       
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

