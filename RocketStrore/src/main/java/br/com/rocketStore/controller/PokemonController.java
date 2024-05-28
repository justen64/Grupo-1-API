package br.com.rocketStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.PokemonResponseDTO;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.repository.PokemonRepository;
import br.com.rocketStore.service.PokemonService;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonRepository repository;
	
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
	
	@GetMapping("/{id}")
	public String buscarSprites(@PathVariable Long id) {
		return service.buscarSprites(id).getBack_default();
	}
	
	@GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Pokemon> optionalPokemon = repository.findById(id);

        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            String imageUrl = pokemon.getSprites().getFront_default();
            byte[] frontDefaultData = service.retrieveImageData(imageUrl);

            if (frontDefaultData != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", service.determineImageType(imageUrl));
                return ResponseEntity.ok()
                        .headers(headers)
                        .body(frontDefaultData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @GetMapping("/imageShiny/{id}")
    public ResponseEntity<byte[]> getImageShiny(@PathVariable Long id) {
        Optional<Pokemon> optionalPokemon = repository.findById(id);

        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            String imageUrl = pokemon.getSprites().getFront_shiny();
            byte[] frontDefaultData = service.retrieveImageData(imageUrl);

            if (frontDefaultData != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", service.determineImageType(imageUrl));
                return ResponseEntity.ok()
                        .headers(headers)
                        .body(frontDefaultData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
}
