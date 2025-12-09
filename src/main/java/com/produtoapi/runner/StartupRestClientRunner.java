package com.produtoapi.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.produtoapi.model.Produto;

import java.util.Arrays;
import java.util.List;

@Component
public class StartupRestClientRunner implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("RestClient em execução!");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/produtos";
		
		Produto[] produtoArray = restTemplate.getForObject(url, Produto[].class);
		List<Produto> produtos = Arrays.asList(produtoArray);
		
		produtos.forEach(produto -> System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco()));
	}
}