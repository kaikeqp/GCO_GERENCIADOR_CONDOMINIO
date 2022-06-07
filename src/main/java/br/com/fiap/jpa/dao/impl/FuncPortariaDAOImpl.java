package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.models.FuncPortaria;

public class FuncPortariaDAOImpl extends HibernateGenericDAO<FuncPortaria, Long> {

	private static FuncPortariaDAOImpl instance = null;
	
	public static FuncPortariaDAOImpl getInstance() {
		if (instance == null) {
			instance = new FuncPortariaDAOImpl();
		}
		
		return instance;
	}
	
	private FuncPortariaDAOImpl() {
		super(FuncPortaria.class);
	}
	
	@Override
	public List<FuncPortaria> listar(EntityManager entityManager) {
		TypedQuery<FuncPortaria> consulta = entityManager.createNamedQuery("FuncPortaria.listar", FuncPortaria.class);
		
		return consulta.getResultList();
	}
	

}
