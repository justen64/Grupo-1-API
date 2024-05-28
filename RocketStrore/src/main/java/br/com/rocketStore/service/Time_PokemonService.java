package br.com.rocketStore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketStore.DTO.Time_PokeResponseDTO;
import br.com.rocketStore.DTO.Time_PokemonDTO;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Time;
import br.com.rocketStore.entity.Time_Pokemon;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PokemonRepository;
import br.com.rocketStore.repository.TimeRepository;
import br.com.rocketStore.repository.Time_PokemonRepository;

@Service
public class Time_PokemonService {

	
	@Autowired
	private Time_PokemonRepository repository;

	@Autowired
	private PokemonRepository pokrepository;

	@Autowired
	private TimeRepository timerepository;

	public Time_PokeResponseDTO inserirTime(Time_PokemonDTO pd) {

		if (pd == null)
			throw new ResourceNotFoundException("Carrinho inválido");
		Optional<Pokemon> pokemon = pokrepository.findById(pd.getIdProduto());
		Optional<Time> time = timerepository.findById(pd.getIdTime());
		Time_Pokemon pd1 = new Time_Pokemon(pd, time.get(), pokemon.get());
		pd1.getId().setTime(time.get());
		pd1.getId().setPokemon(pokemon.get());
		repository.save(pd1);
		return new Time_PokeResponseDTO(pd1);	
	}
	
	public List<Time_PokeResponseDTO> listar(){
        return repository.findAll().stream().map(pok -> new Time_PokeResponseDTO(pok)).collect(Collectors.toList());
    }


}
