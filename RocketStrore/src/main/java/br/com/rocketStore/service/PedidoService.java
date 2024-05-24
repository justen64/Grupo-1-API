package br.com.rocketStore.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.PedidoRequestDTO;
import br.com.rocketStore.DTO.PedidoResponseDTO;
import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.entity.Pedido_Pokemon;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.enuns.StatusENUM;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PokemonService pokemonService;
	
	public List<PedidoResponseDTO> listar() {
		List<Pedido> pedidos = repository.findAll();
		return pedidos.stream().map((c) -> new PedidoResponseDTO(c))
				.collect(Collectors.toList());
	}
	
	public Page<Pedido> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public PedidoResponseDTO inserir(PedidoRequestDTO pedido) {
		
		Pedido f = new Pedido();
		
		f.setCliente(f.getCliente());
		f.setDataPedido(f.getDataPedido());
		f.setStatus(f.getStatus());
		repository.save(f);
		
		Set<Pedido_Pokemon> pokemons = new HashSet<>();
		
		for (Pokemon pokemon : pedido.getPokemon()) {
			pokemon = pokemonService.buscar(pokemon.getId());
			pokemons.add(new Pedido_Pokemon(f, pokemon, LocalDate.now()));
		}
		f.setProdutos(pokemons);
		repository.save(f);
		return new PedidoResponseDTO(f);
	}
	
	
	public PedidoResponseDTO alterarStatus(Long id, StatusENUM status){
		
	Pedido c = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lancamento não encontrado"));
	c.setId(id);
	return new PedidoResponseDTO(c);
	
	}
	
	public PedidoResponseDTO alterarPedido(Long id, Pedido pedido){
		Pedido c = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lancamento não encontrado"));
        c.setId(id);
		repository.save(c);
        return new PedidoResponseDTO(c);
    }
	

	
}
