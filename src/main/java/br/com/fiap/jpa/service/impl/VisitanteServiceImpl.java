package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.VisitanteDAOImpl;
import br.com.fiap.jpa.models.Visitante;
import br.com.fiap.jpa.service.GenericService;

public class VisitanteServiceImpl extends GenericService<Visitante, Long> {
    private static VisitanteServiceImpl instance = null;

    private VisitanteDAOImpl visitanteDAO;

    private VisitanteServiceImpl() {
        this.visitanteDAO = VisitanteDAOImpl.getInstance();
    }

    public static VisitanteServiceImpl getInstance() {

        if (instance == null) {
            instance = new VisitanteServiceImpl();
        }

        return instance;
    }


    @Override
    public void cadastrar(Visitante visitante) {
        try{
            visitanteDAO.salvar(visitante, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Visitante visitante) {
        try{
            visitanteDAO.atualizar(visitante, getEntityManager());
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
            visitanteDAO.remover(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Visitante obter(Long id) {
        Visitante visitante = null;

        try {
            visitante = visitanteDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return visitante;    }

    @Override
    public List<Visitante> listar() {
        List<Visitante> visitantes = null;

        try {
            visitantes = visitanteDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return visitantes;    }
}
