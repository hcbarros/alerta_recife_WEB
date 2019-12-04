/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.recife.tads.alerta_recife.servico;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import static javax.persistence.PersistenceContextType.TRANSACTION;

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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.persistence.PersistenceContextType.TRANSACTION;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Stateless(name = "ejb/PontoDeRiscoServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class PontoDeRiscoServico {

    @PersistenceContext(name = "alerta_recife", type = TRANSACTION)
    protected EntityManager entityManager;
        
    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull PontoDeRisco pontoDeRisco) {
        pontoDeRisco = pontoDeRisco.getId() == null ? null :  
                entityManager.find(PontoDeRisco.class, pontoDeRisco.getId());
        return pontoDeRisco != null;
    }   
    
    public void atualizar(@Valid PontoDeRisco pontoDeRisco) {
        if (existe(pontoDeRisco)) {
            entityManager.merge(pontoDeRisco);
            entityManager.flush();
        }
    }
    
    public void remover(@Valid PontoDeRisco pontoDeRisco){
        if(existe(pontoDeRisco)){
            pontoDeRisco = entityManager.merge(pontoDeRisco);
            entityManager.remove(pontoDeRisco);
            entityManager.flush();
        }
    }
    
    @TransactionAttribute(SUPPORTS)
    public PontoDeRisco consultarPorId(@NotNull Long id) {
        return entityManager.find(PontoDeRisco.class, id);
    }
    
    public List<PontoDeRisco> consultarPontosDeRisco() {
        TypedQuery<PontoDeRisco> query
                = entityManager.createNamedQuery("PontoDeRisco.RecuperarPontosDeRisco",PontoDeRisco.class);
        return query.getResultList();
    }   
      
    public List<PontoDeRisco> consultarPorTipoDeRisco(@Min(value = 1) int tipo) {
        TypedQuery<PontoDeRisco> query
                = entityManager.createNamedQuery("PontoDeRisco.RecuperarPorTipoDeRisco",PontoDeRisco.class);
                query.setParameter(1, tipo);
                return query.getResultList();        
    }
     
    public List<PontoDeRisco> consultarPorEnderecoRua(@NotNull String rua) {
        TypedQuery<PontoDeRisco> query
                = entityManager.createNamedQuery("PontoDeRisco.RecuperarPorEnderecoRua",PontoDeRisco.class);
                query.setParameter(1, rua);
                return query.getResultList();        
    }
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

