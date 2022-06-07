package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.models.MovimentacaoPortaria;

public class MovimentacaoPortariaDAOImpl extends HibernateGenericDAO<MovimentacaoPortaria, Long> {

	private static MovimentacaoPortariaDAOImpl instance = null;
	
	public static MovimentacaoPortariaDAOImpl getInstance() {
		if (instance == null) {
			instance = new MovimentacaoPortariaDAOImpl();
		}
		
		return instance;
	}
	
	private MovimentacaoPortariaDAOImpl() {
		super(MovimentacaoPortaria.class);
	}
	
	@Override
	public List<MovimentacaoPortaria> listar(EntityManager entityManager) {
		TypedQuery<MovimentacaoPortaria> consulta = entityManager.createNamedQuery("MovimentacaoPortaria.listar", MovimentacaoPortaria.class);
		
		return consulta.getResultList();
	}
	
	public List<MovimentacaoPortaria> listarPorTipo(String tipo, EntityManager entityManager) {
		TypedQuery<MovimentacaoPortaria> consulta = entityManager.createNamedQuery("MovimentacaoPortaria.listarPorTipo", MovimentacaoPortaria.class);
		consulta.setParameter("tipo", tipo);		
		return consulta.getResultList();
	}
	

}
