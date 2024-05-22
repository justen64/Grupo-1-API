package br.com.rocketStore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.ClienteRequestDTO;
import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.exception.ConfirmaSenhaException;
import br.com.rocketStore.exception.EmailException;
import br.com.rocketStore.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<ClienteResponseDTO> listar() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((c) -> new ClienteResponseDTO(c))
				.collect(Collectors.toList());
	}

	public ClienteResponseDTO inserir(ClienteRequestDTO cliente){
		if (!cliente.getSenha().equals(cliente.getConfirmaSenha())) {
			throw new ConfirmaSenhaException("As senhas não são iguais!");
		}

		if (repository.findByEmail(cliente.getEmail()) != null) {
			throw new EmailException("Email Já Cadastrado!");
		}
		Cliente u = new Cliente();
		u.setNome(cliente.getNome());
		u.setEmail(cliente.getEmail());
		u.setSenha(encoder.encode(cliente.getSenha()));
		repository.save(u);
		return new ClienteResponseDTO(u);

	}
}
