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

import br.com.serratec.entity.Time;
import br.com.serratec.repository.TimeRepository;

@RestController
@RequestMapping("/times")
public class TimeController {

	@Autowired
	private TimeRepository repository;
	
	@GetMapping
	public List<Time> buscar(){
		return repository.findAll();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time inserir(@RequestBody Time time) {
        return repository.save(time);
    }
	
	@PutMapping
	public ResponseEntity<Time> atualizar (@PathVariable Long id, @RequestBody Time time){
		if(repository.existsById(id)) {
			time.setId(id);
			return ResponseEntity.ok(repository.save(time));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Time> deletar(@PathVariable Long id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/saveAll")
    public ResponseEntity<List<Time>> saveAll(@RequestBody List<Time> time){
        return ResponseEntity.ok(repository.saveAll(time));
    }
	
	
}

