package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<PokemonResponseDTO> listar() {
		return service.listarPokemon();
	}
	
	@GetMapping("/curiosidades")
	public List<String> buscar () {
		return service.listarCuriosidades();
	}
	
	@PutMapping("/mudar/{id}")
	public PokemonResponseDTO mudarCuriosidade(@PathVariable Long id, @RequestBody String curiosidade) {
		return service.atualizarCuriosidade(id, curiosidade);
	}
	
	@DeleteMapping("/del/{id}")
	public PokemonResponseDTO deletarCuriosidade(@PathVariable Long id) {
		return service.deleteCuriosidade(id);
	}
	
	@PostMapping("/add/{id}")
	public PokemonResponseDTO adicionarCuriosidade(@PathVariable Long id, @RequestBody String curiosidade) {
		return service.AdicionarCuriosidade(id, curiosidade);
	}
	
	@PutMapping("/reset/{id}")
	public PokemonResponseDTO resetarCuriosidade(@PathVariable Long id) {
		return service.resetarCuriosidade(id);
	}
}
