package br.com.project.util.all;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public interface ActionViewPadrao extends Serializable{

	abstract void limpaLista() throws Exception;
	
	abstract String save() throws Exception;
	
	abstract void savenotRetorn() throws Exception;
	
	abstract void saveEdit() throws Exception;
	
	abstract void excluir() throws Exception;
	
	abstract String ativar() throws Exception;
	/**
	 * 
	 * @PostConstruct realiza inicializa��o de metodos, valores ou variaveis
	 * @throws Exception
	 */
	@PostConstruct
	abstract String movo() throws Exception;
	
	abstract String editar() throws Exception;
	
	abstract void setarVariacaisNulas() throws Exception;
	
	abstract void consultarEnidade() throws Exception;
	
	abstract void statusOperation(EstatusPersistencia a )throws Exception;
	
	abstract String redirecionarNewEntidade() throws Exception;
	
	abstract String redirecionarFindEntidade() throws Exception;
	
	abstract void addMsg(String msg);
	
}