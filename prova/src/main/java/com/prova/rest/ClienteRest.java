package com.prova.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prova.entidades.Cliente;
import com.prova.entidades.Email;
import com.prova.entidades.Endereco;
import com.prova.entidades.Telefone;
import com.prova.repository.ClienteRepository;
import com.prova.repository.EmailRepository;
import com.prova.repository.EnderecoRepository;
import com.prova.repository.TelefoneRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {
	@Autowired
	private  ClienteRepository repository;
	
	@Autowired
	private  TelefoneRepository tr;
	
	@Autowired 
	private EnderecoRepository er;
	
	@Autowired
	private EmailRepository emr;
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente salvar(@RequestBody @Validated Cliente cliente) {
		System.out.println(cliente);
		Cliente c = repository.save(cliente);
		for(Endereco enderecoSalvo: cliente.getEndereco()) {
			enderecoSalvo.setCliente(c);
			er.save(enderecoSalvo);
		
		}
		
		for(Telefone telefoneSalvo: cliente.getTelefone()) {
			telefoneSalvo.setCliente(c);
			tr.save(telefoneSalvo);
		
		}
		
		for(Email emailSalvo: cliente.getEmail()) {
			emailSalvo.setCliente(c);
			emr.save(emailSalvo);
		
		}
		
		return c;
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>>findAll(){
		List<Cliente> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/buscarid/{id}")
	public Cliente acharPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		 repository.findById(id)
				.map(cliente -> {
					repository.delete(cliente);
					return Void.TYPE;
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		repository.findById(id)
		.map(cliente -> {
			clienteAtualizado.setId(cliente.getId());
			return repository.save(clienteAtualizado);
			
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
}
