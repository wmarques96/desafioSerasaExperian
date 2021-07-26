package com.serasa.crm.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.serasa.crm.model.Cliente;
import com.serasa.crm.repository.ClienteRepository;

@SpringBootTest
class ClienteControllerTest {

	@Autowired
	ClienteController controller;
    
    @Autowired
    ClienteRepository repo ;
    
    @AfterEach
    public void limparDados() { 	
    	repo.deleteAll();
    }
    

	@Test
	final void testAdicionar() {
		Cliente cliente = new Cliente();
		cliente.setNome("william");
		cliente.setDataNasc(new Date());
		cliente.setTelefone("963258745");
		controller.adicionar(cliente);
		assertNotNull(repo.findById(cliente.getId()).get());
	}

	@Test 
	final void testListar() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("william");
		cliente.setDataNasc(new Date());
		cliente.setTelefone("963258745");
		cliente = repo.save(cliente);
		
		List<Cliente> list = controller.listar();
		assertThat(list).size().isEqualTo(1); 
		
	}

	@Test
	final void testEncontrarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("william");
		cliente.setDataNasc(new Date());
		cliente.setTelefone("963258745");
		cliente = repo.save(cliente);
		  
		Cliente clienteEncontrado = controller.encontrarCliente(cliente.getId()).getBody();
	   
	   assertEquals("william", clienteEncontrado.getNome());
	}
	
}
