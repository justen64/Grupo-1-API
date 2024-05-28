package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.Time_PokeResponseDTO;
import br.com.rocketStore.DTO.Time_PokemonDTO;
import br.com.rocketStore.service.Time_PokemonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/time_pokemon")
public class Time_PokemonController {

	@Autowired
	private Time_PokemonService service;
	
	@PostMapping
	public ResponseEntity<Time_PokeResponseDTO> inserir(@Valid @RequestBody Time_PokemonDTO time) {
		return ResponseEntity.ok(service.inserirTime(time));
	}
	
	@GetMapping
    public ResponseEntity<List<Time_PokeResponseDTO>> listaCarrinho(){
        return ResponseEntity.ok(service.listar());
    }
}
