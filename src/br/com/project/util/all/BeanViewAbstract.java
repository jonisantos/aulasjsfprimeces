package br.com.project.util.all;

import org.springframework.stereotype.Component;

@Component
public abstract class BeanViewAbstract implements ActionViewPadrao{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void limpaLista() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savenotRetorn() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveEdit() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String ativar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String movo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setarVariacaisNulas() throws Exception {

		
	}

	@Override
	public void consultarEnidade() throws Exception {

		
	}

	@Override
	public void statusOperation(EstatusPersistencia a) throws Exception {
		Messagens.responseOperation(a);
		
	}
	
	protected void sucesso() throws Exception{
		statusOperation(EstatusPersistencia.SUCESSO);
	}
	
	protected void error() throws Exception{
		statusOperation(EstatusPersistencia.ERROR);
	}

	@Override
	public String redirecionarNewEntidade() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMsg(String msg) {
		Messagens.msg(msg);
		
	}

}
