package com.caioproject.WebService.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caioproject.WebService.entities.User;
import com.caioproject.WebService.repositories.UserRepository;


@Configuration // informando que e uma classe para configuração
@Profile("test") // pegar o nome definido no application.properties para o Spring identificar o
					// perfil que estamos usando
public class TestConfig implements CommandLineRunner { // classe de configuração para o pefil de teste

	@Autowired // anotação para o spring associar a estancia da classe UserRepository dentro
				// dessa classe
	private UserRepository userRepository; // classe responsavel para fazer a modificação no banco de dados,

	@Override
	public void run(String... args) throws Exception { // tudo que esta aqui dentro vai rodar quando iniciar o main, usar o implements CommandLineRunner no incio
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2)); // chamei com o nome que eu dei pra classe, comando saveAll (cria uma lista com as duas variaveis para adicionar ao banco de dados)
	}
}
