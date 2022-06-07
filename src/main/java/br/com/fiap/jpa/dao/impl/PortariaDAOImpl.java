package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.models.Portaria;

public class PortariaDAOImpl extends HibernateGenericDAO<Portaria, Long> {

	private static PortariaDAOImpl instance = null;
	
	public static PortariaDAOImpl getInstance() {
		if (instance == null) {
			instance = new PortariaDAOImpl();
		}
		
		return instance;
	}
	
	private PortariaDAOImpl() {
		super(Portaria.class);
	}
	
	@Override
	public List<Portaria> listar(EntityManager entityManager) {
		TypedQuery<Portaria> consulta = entityManager.createNamedQuery("Portaria.listar", Portaria.class);
		
		return consulta.getResultList();
	}
	

}
