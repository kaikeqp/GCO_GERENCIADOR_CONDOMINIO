package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.MovimentacaoPortariaDAOImpl;
import br.com.fiap.jpa.models.MovimentacaoPortaria;
import br.com.fiap.jpa.service.GenericService;

public class MovimentacaoPortariaServiceImpl extends GenericService<MovimentacaoPortaria, Long> {
    private static MovimentacaoPortariaServiceImpl instance = null;

    private MovimentacaoPortariaDAOImpl movimentacaoPortariaDAO;

    private MovimentacaoPortariaServiceImpl() {
        this.movimentacaoPortariaDAO = MovimentacaoPortariaDAOImpl.getInstance();
    }

    public static MovimentacaoPortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new MovimentacaoPortariaServiceImpl();
        }

        return instance;
    }


    @Override
    public void cadastrar(MovimentacaoPortaria movimentacaoPortaria) {
        try{
            movimentacaoPortariaDAO.salvar(movimentacaoPortaria, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(MovimentacaoPortaria movimentacaoPortaria) {
        try{
            movimentacaoPortariaDAO.atualizar(movimentacaoPortaria, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            movimentacaoPortariaDAO.remover(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public MovimentacaoPortaria obter(Long id) {
        MovimentacaoPortaria movimentacaoPortaria = null;

        try {
            movimentacaoPortaria = movimentacaoPortariaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return movimentacaoPortaria;    }

    @Override
    public List<MovimentacaoPortaria> listar() {
        List<MovimentacaoPortaria> movimentacaoPortarias = null;

        try {
            movimentacaoPortarias = movimentacaoPortariaDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return movimentacaoPortarias;    }
    
	public List<MovimentacaoPortaria> listarPorTipo(String tipo) {
		List<MovimentacaoPortaria> movimentacoes = null;
		
		try {
			movimentacoes = movimentacaoPortariaDAO.listarPorTipo(tipo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacoes;
	}
}
