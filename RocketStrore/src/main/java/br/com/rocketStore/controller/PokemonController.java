package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.PokemonResponseDTO;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.service.PokemonService;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService service;
	
	@PostMapping
	public ResponseEntity<List<PokemonResponseDTO>> inserir() throws Exception{
		return ResponseEntity.ok(service.inserir());
	}

	@GetMapping()
	public List<Pokemon> listar() {
		return service.listarClientes();
	}
}
