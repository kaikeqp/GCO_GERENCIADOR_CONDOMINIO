package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.FuncPortariaDAOImpl;
import br.com.fiap.jpa.models.FuncPortaria;
import br.com.fiap.jpa.service.GenericService;

public class FuncPortariaServiceImpl extends GenericService<FuncPortaria, Long> {
    private static FuncPortariaServiceImpl instance = null;

    private FuncPortariaDAOImpl funcPortariaDAO;

    private FuncPortariaServiceImpl() {
        this.funcPortariaDAO = FuncPortariaDAOImpl.getInstance();
    }

    public static FuncPortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new FuncPortariaServiceImpl();
        }

        return instance;
    }


    @Override
    public void cadastrar(FuncPortaria funcPortaria) {
        try{
            funcPortariaDAO.salvar(funcPortaria, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(FuncPortaria funcPortaria) {
        try{
            funcPortariaDAO.atualizar(funcPortaria, getEntityManager());
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
            funcPortariaDAO.remover(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public FuncPortaria obter(Long id) {
        FuncPortaria funcPortaria = null;

        try {
            funcPortaria = funcPortariaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return funcPortaria;    }

    @Override
    public List<FuncPortaria> listar() {
        List<FuncPortaria> funcPortarias = null;

        try {
            funcPortarias = funcPortariaDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return funcPortarias;    }
}
