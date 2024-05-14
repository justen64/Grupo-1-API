package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.serratec.entity.Atleta;
import br.com.serratec.repository.AtletaRepository;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

	@Autowired
	private AtletaRepository repository;
	
	@PostMapping
	public Atleta inseir(@RequestBody Atleta atleta) {
		return repository.save(atleta);
	}
	
	@PutMapping
	public ResponseEntity<Atleta> atualizar (@PathVariable Long id, @RequestBody Atleta atleta){
		if(repository.existsById(id)) {
			atleta.setId(id);
			return ResponseEntity.ok(repository.save(atleta));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Atleta> deletar(@PathVariable Long id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/saveAll")
    public ResponseEntity<List<Atleta>> saveAll(@RequestBody List<Atleta> atleta){
        return ResponseEntity.ok(repository.saveAll(atleta));
    }
	
	@GetMapping("{id}")
	public ResponseEntity<Atleta> buscar(@PathVariable Long id) {
		Optional<Atleta> atleta = repository.findById(id);
		if(atleta.isPresent()){
			return ResponseEntity.ok(atleta.get());
		}
		else {
			return ResponseEntity.notFound().build();	
		}
	}
}

