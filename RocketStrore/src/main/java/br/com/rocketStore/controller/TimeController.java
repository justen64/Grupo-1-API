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

import br.com.rocketStore.DTO.TimeRequestDTO;
import br.com.rocketStore.DTO.TimeResponseDTO;
import br.com.rocketStore.entity.Time;
import br.com.rocketStore.service.TimeService;

@RestController
@RequestMapping("/times")
public class TimeController {

	@Autowired
	public TimeService service;
	
	@GetMapping
	public List<TimeResponseDTO> listar(){
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<TimeResponseDTO> inserir(@RequestBody TimeRequestDTO pedido) {
		TimeResponseDTO p = service.inserir(pedido);
		return ResponseEntity.created(null).body(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TimeResponseDTO> alterarTime(@PathVariable Long id, @RequestBody Time time) {
		TimeResponseDTO TimeAtualizado = service.alterarTime(id, time);
		return ResponseEntity.ok(TimeAtualizado);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTime(@PathVariable Long id) {
        service.deletarTime(id);
        return ResponseEntity.noContent().build();
    }

}
