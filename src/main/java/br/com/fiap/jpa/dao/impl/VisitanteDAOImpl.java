package br.com.fiap.jpa.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	public List<Visitante> listarPorNomeLike(String nome, EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);

        Root<Visitante> visitanteRoot = criteriaQuery.from(Visitante.class);

        Predicate predicate = builder.like(
                builder.upper(visitanteRoot.get("nome")), nome + "%");

        criteriaQuery.select(visitanteRoot);
        criteriaQuery.where(predicate);

        TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }
	
	public List<Visitante> listarPorCpfEqual(String cpf, EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);

        Root<Visitante> visitanteRoot = criteriaQuery.from(Visitante.class);

        Predicate predicate = builder.equal(
                visitanteRoot.get("cpf"), cpf);

        criteriaQuery.select(visitanteRoot);
        criteriaQuery.where(predicate);

        TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }
	
	public List<Visitante> listarPorDtCadastro(LocalDateTime dataCadastro, EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);

        Root<Visitante> visitanteRoot = criteriaQuery.from(Visitante.class);

        Predicate predicate = builder.greaterThanOrEqualTo(
                visitanteRoot.get("dataCadastro"), dataCadastro);

        criteriaQuery.select(visitanteRoot);
        criteriaQuery.where(predicate);

        TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }
	

}
