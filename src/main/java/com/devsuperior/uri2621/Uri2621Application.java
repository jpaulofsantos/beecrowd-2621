package com.devsuperior.uri2621;

import com.devsuperior.uri2621.projection.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProductMinProjection> listProjection = repository.searchSQL();

		System.out.println("");
		System.out.println("------SQL------");

		for (ProductMinProjection item: listProjection){
			System.out.println(item.getName());
		}

		System.out.println("");
		System.out.println("------JPQL------");

		for (ProductMinProjection item: listProjection){
			System.out.println(item.getName());
		}
		
	}
}
