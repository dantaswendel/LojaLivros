package br.com.wendel.lojaLivros.repository;


import br.com.wendel.lojaLivros.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {

    private static String INSERT = "insert into cliente (nome) values (?)";
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object []{cliente.getNome()});
        return cliente;
    }

}
