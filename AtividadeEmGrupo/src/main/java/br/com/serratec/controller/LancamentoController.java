package br.com.serratec.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoVendasService;

@RestController
@RequestMapping("/vendedores")
public class LancamentoController {

	@Autowired
	private LancamentoVendasService service;
	
	@GetMapping("{id}")
	public ResponseEntity<LancamentoVendasMostrarDTO> listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorID(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoVendas inserirLancamento(@RequestBody LancamentoVendas venda) {
		return repository.save(venda);
	}
	
	@GetMapping
	public List<LancamentoVendas> listar() {
		return repository.findAll();
	}
	
	@DeleteMapping("{Id}")
	public ResponseEntity<Void> deletar(@PathVariable Long Id) {
		if(repository.existsById(Id)) {
			repository.deleteById(Id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{Id}")
	public ResponseEntity<LancamentoVendas> Alterar(@PathVariable Long Id, @RequestBody LancamentoVendas vendas) {
		if(repository.existsById(Id)) {
			return ResponseEntity.ok(repository.save(vendas));
		}
		return ResponseEntity.notFound().build();
	}
	
}
