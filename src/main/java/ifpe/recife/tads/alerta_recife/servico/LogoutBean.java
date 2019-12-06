
package ifpe.recife.tads.alerta_recife.servico;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MASC
 */
@RequestScoped
@Named("logoutBean")
public class LogoutBean implements Serializable {
    
    
    private FacesContext facesContext;

       
    public String logout() throws ServletException {
        HttpSession session = (HttpSession)
                facesContext.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        return "sair";
    }
}
