package br.com.rocketStore.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rocketStore.entity.Time;

public class TimeResponseDTO {

	private ClienteResponseDTO cliente;
	private List<PokemonResponseDTO> pokemons;
	private String descricao;

	
	public TimeResponseDTO(Time time) {
		this.cliente = new ClienteResponseDTO(time.getCliente());
		this.pokemons = time.getPokemons().stream()
                .map(tp -> new PokemonResponseDTO(tp.getId().getPokemon()))
                .collect(Collectors.toList());
		this.descricao = time.getDescricao();

	}

	public ClienteResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}

	public List<PokemonResponseDTO> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<PokemonResponseDTO> pokemons) {
		this.pokemons = pokemons;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
