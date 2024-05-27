package br.com.rocketStore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;
import br.com.rocketStore.exception.CepException;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public ClienteResponseDTO inserir(Cliente cliente) {
		Endereco endereco = cliente.getEndereco();
		if (endereco != null) {
			RestTemplate rs = new RestTemplate();
			String url = "http://viacep.com.br/ws/" + endereco.getCep() + "/json";
			System.out.println(url);
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				enderecoViaCep.get().setNumero(endereco.getNumero());
				cliente.setEndereco(enderecoViaCep.get());
			} else {
				throw new CepException("Cep Não Encontrado!");
			}
		} else {
			throw new CepException("Por favor, insira um endereço!");
		}
		repository.save(cliente);
		return new ClienteResponseDTO(cliente);
	}

	public List<ClienteResponseDTO> listar() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((c) -> new ClienteResponseDTO(c)).collect(Collectors.toList());
	}

	public Page<Cliente> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public ClienteResponseDTO alterarCliente(Long id, Cliente cliente) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lançamento não encontrado"));
		cliente.setId(id);
		repository.save(cliente);
		ClienteResponseDTO response = new ClienteResponseDTO(cliente); 
		return response;
	}
}
