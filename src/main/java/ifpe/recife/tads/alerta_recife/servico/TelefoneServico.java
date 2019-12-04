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

@Stateless(name = "ejb/TelefoneServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class TelefoneServico {

    @PersistenceContext(name = "alerta_recife", type = TRANSACTION)
    protected EntityManager entityManager;
        
    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull Telefone telefone) {
        telefone = telefone.getId() == null ? null :  
                entityManager.find(Telefone.class, telefone.getId());
        return telefone != null;
    }   
    
    public void atualizar(@Valid Telefone telefone) {
        if (existe(telefone)) {
            entityManager.merge(telefone);
            entityManager.flush();
        }
    }

    public void persistir(@Valid Telefone telefone) {
        if (!existe(telefone)) {
            entityManager.persist(telefone);
        }
    }
    
    public void remover(@Valid Telefone telefone){
        if(existe(telefone)){
            telefone = entityManager.merge(telefone);
            entityManager.remove(telefone);
            entityManager.flush();
        }
    }
    
    @TransactionAttribute(SUPPORTS)
    public Telefone consultarPorId(@NotNull Long id) {
        return entityManager.find(Telefone.class, id);
    }
    
    public List<Telefone> consultarTelefones() {
        TypedQuery<Telefone> query
                = entityManager.createNamedQuery("Telefone.RecuperarTelefones",Telefone.class);
        return query.getResultList();
    }   
      
    public Telefone consultarPorNumero(@NotNull String numero) {
        TypedQuery<Telefone> query
                = entityManager.createNamedQuery("Telefone.RecuperarPorNumero",Telefone.class);
                query.setParameter("numero", numero);
                try{
                    Object obj = query.getSingleResult();
                    return (Telefone) obj;
                }catch(javax.persistence.NoResultException e) {
                    return null;
                }  
    }
     
    public List<Telefone> consultarPorEmailUsuario(@NotNull String email) {
        TypedQuery<Telefone> query
                = entityManager.createNamedQuery("Telefone.RecuperarPorUsuario",Telefone.class);
                query.setParameter(1, email);
                return query.getResultList();        
    }
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

