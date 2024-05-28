package br.com.rocketStore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.ClienteResponseDTO;
import br.com.rocketStore.DTO.PedidoResponseDTO;
import br.com.rocketStore.DTO.TimeRequestDTO;
import br.com.rocketStore.DTO.TimeResponseDTO;
import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Pedido_Pokemon;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Time;
import br.com.rocketStore.entity.Time_Pokemon;
import br.com.rocketStore.exception.ClienteException;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.TimeRepository;
import jakarta.transaction.Transactional;

@Service
public class TimeService {

	
	@Autowired
	private TimeRepository repository;

	@Autowired
	private PokemonService pokemonService;
	
	public List<TimeResponseDTO> listar() {
		List<Time> time = repository.findAll();
		return time.stream().map((c) -> new TimeResponseDTO(c)).collect(Collectors.toList());


	}
	@Transactional
	public TimeResponseDTO inserir(TimeRequestDTO time) {

		Time f = new Time();
		if (time.getCliente() != null) {
			f.setCliente(time.getCliente());
			repository.save(f);

			Set<Time_Pokemon> pokemons = new HashSet<>();

			for (Pokemon pokemon : time.getPokemon()) {
				pokemon = pokemonService.buscar(pokemon.getId());
				pokemons.add(new Time_Pokemon(f, pokemon));
			}
			f.setPokemons(pokemons);
			f.setDescricao(time.getDescricao());
			repository.save(f);
			TimeResponseDTO response = new TimeResponseDTO(f);
			return response;
		} else {
			throw new ClienteException("Cliente apresentado não encontrado!");
		}
	}
	
	public TimeResponseDTO alterarTime(Long id, Time time) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lançamento não encontrado"));
		time.setId(id);
		time.setCliente(time.getCliente());
		time.setDescricao(time.getDescricao());
		time.setPokemons(time.getPokemons());
		
		repository.save(time);
		TimeResponseDTO response = new TimeResponseDTO(time); 
		return response;
	}

    public void deletarTime(Long id) {
        Time existente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Time não encontrado"));
        repository.delete(existente);
    }
}
