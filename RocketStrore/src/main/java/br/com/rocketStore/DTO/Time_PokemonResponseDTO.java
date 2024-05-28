package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Time_Pokemon;

public class Time_PokemonResponseDTO {
	private String nomePokemon;

	

	public Time_PokemonResponseDTO(Time_Pokemon save) {
		this.nomePokemon = save.getId().getPokemon().getNome();
	}
	public String getNomePokemon() {
		return nomePokemon;
	}
	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}
}
