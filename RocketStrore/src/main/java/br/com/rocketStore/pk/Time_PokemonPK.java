package br.com.rocketStore.pk;

import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Time;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Time_PokemonPK {

	@ManyToOne
	@JoinColumn(name = "id_time")
	private Time time;

	@ManyToOne
	@JoinColumn(name = "id_pokemon")
	private Pokemon pokemon;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}
