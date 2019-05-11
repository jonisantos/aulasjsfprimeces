package br.com.project.bean.view;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


import br.com.project.model.classes.Entidade;

@Scope(value = "session")
@Component(value = "contextoBean")
public class ContextoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String USER_LOGADO_SESSAO = "userLogadoSessao";
	


	/**
	 * 
	 * @return String Usu�rio logado remote user
	 */
	public String getUserLogado() {
		return getExternalContext().getRemoteUser();
	}

	/**
	 * 
	 * @return String Usu�rio logado user principal
	 */
	public String getUserPrincipal() {
		return getExternalContext().getUserPrincipal().getName();
	}

	/**
	 * 
	 * @return String Usu�rio logado Authentication Spring security
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 
	 * @return ExternalContext da application
	 */
	public ExternalContext getExternalContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		return external;
	}

	/**
	 * @return Entidade logado na sess�o atualmente
	 */
	
	
	/**
	 * Retorna se o usuario logado possui os acesso passados como paramentro, este metodo destina-se ao uso onde n�o � possivel usar
	 * as tags do spring security
	 */
	public boolean possuiAcesso(String... acessos) {
		for (String acesso : acessos) {
			for (GrantedAuthority autorizacao : getAuthentication().getAuthorities()){ 
				if (autorizacao.getAuthority().trim().equals(acesso.trim())){
					return true;
				}
			}
		}
		return false;
	}

}
