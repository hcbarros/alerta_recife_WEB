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

@Stateless(name = "ejb/SolicitacaoServico") // O professor comentou que é padrão
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class SolicitacaoServico {

    @PersistenceContext(name = "alerta_recife", type = TRANSACTION)
    protected EntityManager entityManager;
        
    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull Solicitacao solicitacao) {
        solicitacao = solicitacao.getId() == null ? null :  
                entityManager.find(Solicitacao.class, solicitacao.getId());
        return solicitacao != null;
    }   
    
    public void atualizar(@Valid Solicitacao solicitacao) {
        if (existe(solicitacao)) {
            entityManager.merge(solicitacao);
            entityManager.flush();
        }
    }

    public void persistir(@Valid Solicitacao solicitacao) {
        if (!existe(solicitacao)) {
            entityManager.persist(solicitacao);
        }
    }
    
    public void remover(@Valid Solicitacao solicitacao){
        if(existe(solicitacao)){
            solicitacao = entityManager.merge(solicitacao);
            entityManager.remove(solicitacao);
            entityManager.flush();
        }
    }
    
    @TransactionAttribute(SUPPORTS)
    public Solicitacao consultarPorId(@NotNull Long id) {
        return entityManager.find(Solicitacao.class, id);
    }
    
    public List<Solicitacao> consultarSolicitacoesNaoAtendidas() {
        TypedQuery<Solicitacao> query
                = entityManager.createNamedQuery("Solicitacao.RecuperarNaoAtendidos",Solicitacao.class);
        return query.getResultList();
    }   
      
    public List<Solicitacao> consultarPorTipoDeSolicitacao(@Min(value = 1) int tipo) {
        TypedQuery<Solicitacao> query
                = entityManager.createNamedQuery("Solicitacao.RecuperarPorTipo",Solicitacao.class);
                query.setParameter(1, tipo);
                return query.getResultList();        
    }
     
    public List<Solicitacao> consultarPorEmailUsuario(@NotNull String email) {
        TypedQuery<Solicitacao> query
                = entityManager.createNamedQuery("Solicitacao.RecuperarPorUsuario",Solicitacao.class);
                query.setParameter(1, email);
                return query.getResultList();        
    }
        
}
// Nem precisa da maioria das anotações. O professor colocou para ilustrar.

