package com.serasa.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.crm.model.Cliente;
import com.serasa.crm.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/listarClientes")
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();

	}
	
	@GetMapping("/encontrarCliente/{id}")
	public ResponseEntity<Cliente> encontrarCliente(@PathVariable @NumberFormat Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok().body(cliente.get());

		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("/cadastrarCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	

}
