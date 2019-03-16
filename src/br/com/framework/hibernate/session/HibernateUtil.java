package br.com.framework.hibernate.session;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

/*
 * Reponsavel por estabelecer a conexao com hibernate
 */
public class HibernateUtil implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java:/com/env/jdbc/datasource";
	
	private static SessionFactory sessionFactory = buildSessionFactory();

	/**
	 *Reponsável por ler o arquivo de configuração hibernate.cfg.xml 
	 * @return
	 */	
	private static SessionFactory buildSessionFactory() {
		
		try {
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			
			return sessionFactory;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao criar conexão SessionFactory");
			
		}
	}
	
	/**
	 * Retorna a sessionFqactory corrente
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	/**
	 * Retonar a sessão da SessionFactory
	 * @return Session
	 */
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * Abre uma nova sessão no SessionFactory
	 * @return Session
	 */
	public static Session openSession() {
		
		if(sessionFactory == null)
		buildSessionFactory();
					
		return sessionFactory.openSession();
	}
	
	/**
	 * Obtem a conection do provedor de conexões configurado
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnectionProvider() throws SQLException{
		
		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
	}

	/**
	 * 
	 * @return Connection no InitialContext java:/com/env/jdbc/datasouce
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) (DataSource) context.lookup(JAVA_COMP_ENV_JDBC_DATA_SOURCE);
		return ds.getConnection();
	}
	
	/**
	 * 
	 * @return Datasource JNDI tomcat
	 * @throws NamingException
	 * @throws NamingException
	 */
	public DataSource getDatasourceJndi() throws NamingException{
		InitialContext context = new InitialContext();
		return (DataSource) context.lookup(br.com.framework.implementacao.crud.VariavelConexaoUtil.JAVA_COMP_ENV_JDBC_DATA_SOURCE);
	}
}
