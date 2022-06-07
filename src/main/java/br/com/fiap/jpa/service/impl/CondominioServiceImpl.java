package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.CondominioDAOImpl;
import br.com.fiap.jpa.models.Condominio;
import br.com.fiap.jpa.service.GenericService;

public class CondominioServiceImpl extends GenericService<Condominio, Long> {
    private static CondominioServiceImpl instance = null;

    private CondominioDAOImpl condominioDAO;

    private CondominioServiceImpl() {
        this.condominioDAO = CondominioDAOImpl.getInstance();
    }

    public static CondominioServiceImpl getInstance() {

        if (instance == null) {
            instance = new CondominioServiceImpl();
        }

        return instance;
    }


    @Override
    public void cadastrar(Condominio condominio) {
        try{
            condominioDAO.salvar(condominio, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Condominio condominio) {
        try{
            condominioDAO.atualizar(condominio, getEntityManager());
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
            condominioDAO.remover(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Condominio obter(Long id) {
        Condominio condominio = null;

        try {
            condominio = condominioDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return condominio;    }

    @Override
    public List<Condominio> listar() {
        List<Condominio> condominios = null;

        try {
            condominios = condominioDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return condominios;    }
}
