package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.models.Visitante;

public class VisitanteDAOImpl extends HibernateGenericDAO<Visitante, Long> {

	private static VisitanteDAOImpl instance = null;
	
	public static VisitanteDAOImpl getInstance() {
		if (instance == null) {
			instance = new VisitanteDAOImpl();
		}
		
		return instance;
	}
	
	private VisitanteDAOImpl() {
		super(Visitante.class);
	}
	
	@Override
	public List<Visitante> listar(EntityManager entityManager) {
		TypedQuery<Visitante> consulta = entityManager.createNamedQuery("Visitante.listar", Visitante.class);
		
		return consulta.getResultList();
	}
	

}
