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

@Stateless(name = "ejb/ContatoServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class ContatoServico {

    @PersistenceContext(name = "alerta_recife", type = TRANSACTION)
    protected EntityManager entityManager;
        
    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull Contato contato) {
        contato = contato.getId() == null ? null :  
                entityManager.find(Contato.class, contato.getId());
        return contato != null;
    }
    
    public void remover(Contato contato){
        if(existe(contato)){
            contato = entityManager.merge(contato);
            entityManager.remove(contato);
            entityManager.flush();
        }
    }
       
    public void persistir(@Valid Contato contato) {
        if (!existe(contato)) {
            entityManager.persist(contato);
        }
    }

    public void atualizar(@Valid Contato contato) {
        if (existe(contato)) {
            entityManager.merge(contato);
            entityManager.flush();
        }
    }

    @TransactionAttribute(SUPPORTS)
    public Contato consultarPorId(@NotNull Long id) {
        return entityManager.find(Contato.class, id);
    }
    
    public List<Contato> consultarContatos() {
        TypedQuery<Contato> query
                = entityManager.createNamedQuery("Contato.RecuperarContatos",Contato.class);
        return query.getResultList();
    }
    
    public Contato consultarPorDescricao(@NotNull String descricao) {
        TypedQuery<Contato> query
                = entityManager.createNamedQuery("Contato.RecuperarPorDescricao",Contato.class);
                query.setParameter("descricao", descricao);
                try{
                    Object obj = query.getSingleResult();
                    return (Contato) obj;
                }catch(javax.persistence.NoResultException e) {
                    return null;
                }                
    }
      
    public Contato consultarPorNumero(@NotNull String numero) {
        TypedQuery<Contato> query
                = entityManager.createNamedQuery("Contato.RecuperarPorNumero",Contato.class);
                query.setParameter("numero", numero);
                try{
                    Object obj = query.getSingleResult();
                    return (Contato) obj;
                }catch(javax.persistence.NoResultException e) {
                    return null;
                }          
    }
       
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

