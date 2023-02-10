package br.com.wendel.lojaLivros;

import br.com.wendel.lojaLivros.model.Cliente;
import br.com.wendel.lojaLivros.repository.ClientesRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LojaLivrosApplication {

	@Bean
	public CommandLineRunner init (@Autowired ClientesRepository clientesRepository){
		return args  -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Wendel");
			ClientesRepository.salvar (cliente);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaLivrosApplication.class, args);
	}

}
