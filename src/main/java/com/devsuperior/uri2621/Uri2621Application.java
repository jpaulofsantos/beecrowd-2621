package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projection.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProductMinProjection> listProjection = repository.searchSQL(10, 300, "E");
		List<ProductMinDTO> list = listProjection.stream().map(x-> new ProductMinDTO(x)).collect(Collectors.toList());
		List<ProductMinDTO> listProjectionDTO = repository.searchJPQL(10, 400, "E");


		System.out.println("");
		System.out.println("------SQL-PROJ------");

		for (ProductMinProjection item: listProjection){
			System.out.println(item.getName());
		}

		System.out.println("");
		System.out.println("------SQL-DTO------");

		for (ProductMinDTO item: list){
			System.out.println(item.getName());
		}

		System.out.println("");
		System.out.println("------JPQL------");

		for (ProductMinDTO item: listProjectionDTO){
			System.out.println(item.getName());
		}
	}
}
