package com.caioproject.WebService.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caioproject.WebService.entities.Category;
import com.caioproject.WebService.entities.Order;
import com.caioproject.WebService.entities.Product;
import com.caioproject.WebService.entities.User;
import com.caioproject.WebService.entities.enums.OrderStatus;
import com.caioproject.WebService.repositories.CategoryRepository;
import com.caioproject.WebService.repositories.OrderRepository;
import com.caioproject.WebService.repositories.ProductRepository;
import com.caioproject.WebService.repositories.UserRepository;


@Configuration // informando que e uma classe para configuração 
@Profile("test") // pegar o nome definido no application.properties para o Spring identificar o perfil que estamos usando
public class TestConfig implements CommandLineRunner { // classe de configuração para o pefil de teste

	@Autowired // anotação para o spring associar a estancia da classe UserRepository dentro dessa classe
	private UserRepository userRepository; // classe responsavel para fazer a modificação no banco de dados

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private	ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception { // tudo que esta aqui dentro vai rodar quando iniciar o main, usar o implements CommandLineRunner no incio
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.SHIPPED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT); 
		
		userRepository.saveAll(Arrays.asList(u1,u2)); // chamei com o nome que eu dei pra classe, comando saveAll (cria uma lista com as duas variaveis para adicionar ao banco de dados)
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
