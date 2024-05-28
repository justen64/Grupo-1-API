package br.com.rocketStore.entity;

import br.com.rocketStore.DTO.Time_PokemonDTO;
import br.com.rocketStore.pk.Time_PokemonPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Time_Pokemon {

	@EmbeddedId
	private Time_PokemonPK id = new Time_PokemonPK();
	private Integer quantidade;

	
	
	public Time_Pokemon() {
		super();
	}

	public Time_Pokemon(Time_PokemonDTO pd, Time time, Pokemon pokemon) {
		super();
		this.id.setTime(time);;
		this.id.setPokemon(pokemon);
		this.quantidade = pd.getQuantidade();
	}

	public Time_Pokemon(Time time, Pokemon pokemon) {
		this.id.setTime(time);;
		this.id.setPokemon(pokemon);
	}

	public Time_PokemonPK getid() {
		return id;
	}

	public Time_PokemonPK getId() {
		return id;
	}

	public void setId(Time_PokemonPK id) {
		this.id = id;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	
}