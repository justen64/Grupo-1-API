package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Time_Pokemon;

public class Time_PokeResponseDTO {
	private Long numeroDoTime;

	private Time_PokemonResponseDTO pokemons;

	public Time_PokeResponseDTO(Time_Pokemon pok) {
		this.numeroDoTime = pok.getId().getTime().getId();
		this.pokemons = new Time_PokemonResponseDTO(pok);
	}

	public Long getNumeroDoTime() {
		return numeroDoTime;
	}

	public void setNumeroDoTime(Long numeroDoTime) {
		this.numeroDoTime = numeroDoTime;
	}

	public Time_PokemonResponseDTO getPokemons() {
		return pokemons;
	}

	public void setPokemons(Time_PokemonResponseDTO pokemons) {
		this.pokemons = pokemons;
	}

}
