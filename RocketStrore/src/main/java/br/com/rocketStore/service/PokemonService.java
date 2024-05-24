package br.com.rocketStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PokemonRepository;

@Service
public class PokemonService {

	
	@Autowired
	private PokemonRepository repository;
	
	public Pokemon buscar(Long id) {
		Pokemon pokemon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pokemon não encontrado!"));
		return pokemon;
	}
}
