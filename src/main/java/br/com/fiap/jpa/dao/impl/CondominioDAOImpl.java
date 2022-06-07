package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.models.Condominio;

public class CondominioDAOImpl extends HibernateGenericDAO<Condominio, Long> {

	private static CondominioDAOImpl instance = null;
	
	public static CondominioDAOImpl getInstance() {
		if (instance == null) {
			instance = new CondominioDAOImpl();
		}
		
		return instance;
	}
	
	private CondominioDAOImpl() {
		super(Condominio.class);
	}
	
	@Override
	public List<Condominio> listar(EntityManager entityManager) {
		TypedQuery<Condominio> consulta = entityManager.createNamedQuery("Condominio.listar", Condominio.class);
		
		return consulta.getResultList();
	}
	

}
