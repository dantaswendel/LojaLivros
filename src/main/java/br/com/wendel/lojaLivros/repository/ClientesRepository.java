package br.com.wendel.lojaLivros.repository;


import br.com.wendel.lojaLivros.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    @Autowired
    private static EntityManager entityManager;
    @Transactional
    public static Cliente salvar(Cliente cliente){
      entityManager.persist(cliente);
        return cliente;
    }
    @Transactional
    public static Cliente atualizar (Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }
    @Transactional
    public void  deletar (Cliente cliente){

        entityManager.remove(cliente);
    }
    @Transactional
    public void  deletarId (Integer id){
       Cliente cliente  = entityManager.find(Cliente.class, id);
       deletar(cliente);
    }

    @Transactional
    public List<Cliente> obterTodos (String nome){
    return entityManager
            .createQuery(SqlStringGenerationContext: "from Cliente", Cliente.class)
            .getResultList();


    }



}

