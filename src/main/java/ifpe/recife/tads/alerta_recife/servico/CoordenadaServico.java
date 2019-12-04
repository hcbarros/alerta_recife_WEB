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

@Stateless(name = "ejb/CoordenadaServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class CoordenadaServico {

    @PersistenceContext(name = "alerta_recife", type = TRANSACTION)
    protected EntityManager entityManager;
        
    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull Coordenada coordenada) {
        coordenada = coordenada.getId() == null ? null :  
                entityManager.find(Coordenada.class, coordenada.getId());
        return coordenada != null;
    }   
       
    public void persistir(@Valid Coordenada coordenada) {
        if (!existe(coordenada)) {
            entityManager.persist(coordenada);
        }
    }

    public void atualizar(@Valid Coordenada coordenada) {
        if (existe(coordenada)) {
            entityManager.merge(coordenada);
            entityManager.flush();
        }
    }

    @TransactionAttribute(SUPPORTS)
    public Coordenada consultarPorId(@NotNull Long id) {
        return entityManager.find(Coordenada.class, id);
    }
    
    public List<Coordenada> consultarCoordenadas() {
        TypedQuery<Coordenada> query
                = entityManager.createNamedQuery("Coordenada.RecuperarCoordenadas",Coordenada.class);
        return query.getResultList();
    }   
      
    public List<Coordenada> consultarPorPontoX(@NotNull double pontoX) {
        TypedQuery<Coordenada> query
                = entityManager.createNamedQuery("Coordenada.RecuperarPorPontoX",Coordenada.class);
                query.setParameter(1, pontoX);
                return query.getResultList();        
    }
       
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

