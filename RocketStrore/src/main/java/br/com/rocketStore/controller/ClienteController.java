package br.com.rocketStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketStore.DTO.ClienteRequestDTO;
import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return service.listar();
	}

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@RequestBody ClienteRequestDTO cliente) {
		ClienteResponseDTO c = service.inserir(cliente);
		return ResponseEntity.created(null).body(c);
	}
}
