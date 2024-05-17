package br.com.serratec.controller;

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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentoVendas")
public class LancamentoController {
	
	@Autowired
	private LancamentoVendasService service;
	
	@GetMapping("{id}")
	public ResponseEntity<LancamentoVendasMostrarDTO> listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorID(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LancamentoVendas> inserirLancamento(@Valid @RequestBody LancamentoVendas venda) {
		return ResponseEntity.ok(service.inserirLancamento(venda));
	}
	
	@GetMapping
	public ResponseEntity<List<LancamentoVendasMostrarDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseEntity<Void>> deletar(@PathVariable Long Id) {
		service.deletar(Id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
    public ResponseEntity<LancamentoVendasMostrarDTO> Alterar(@PathVariable Long id,@Valid @RequestBody LancamentoVendas vendas) {
        return ResponseEntity.ok(service.alterarLancamento(id, vendas));
    }
}
