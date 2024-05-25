package br.com.rocketStore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.ClienteRequestDTO;
import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.DTO.EnderecoDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.exception.ConfirmaSenhaException;
import br.com.rocketStore.exception.EmailException;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
    @Autowired
    private EnderecoService enderecoService;
	
	public List<ClienteResponseDTO> listar() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((c) -> new ClienteResponseDTO(c,null))
				.collect(Collectors.toList());
	}
	
	public Page<Cliente> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public ClienteResponseDTO inserir(ClienteRequestDTO cliente) {
		if (!cliente.getSenha().equals(cliente.getConfirmaSenha())) {
			throw new ConfirmaSenhaException("Confirma de senha não confere!");
		}

		if (repository.findByEmail(cliente.getEmail()) != null) {
			throw new EmailException("Email Já Existe na Base");
		}
		
		EnderecoDTO e = EnderecoService.buscar
		Cliente c = new Cliente();
		c.setNome(c.getNome());
		c.setTelefone1(c.getTelefone1());;
		c.setTelefone2(c.getTelefone2());;
		c.setEmail(c.getEmail());
		c.setCPF(c.getCPF());
		c.setCep(c.getCep());
		c.setSenha(encoder.encode(cliente.getSenha()));
		repository.save(c);
		return new ClienteResponseDTO(c);

	}
	
	public ClienteResponseDTO alterarCliente(Long id, Cliente cliente){
		Cliente c = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lançamento não encontrado"));
        c.setId(id);
		repository.save(c);
        return new ClienteResponseDTO(c);
    }
}
