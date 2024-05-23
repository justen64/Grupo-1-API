package br.com.rocketStore.entity;

import java.time.LocalDate;

import br.com.rocketStore.pk.Pedido_PokemonPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Pedido_Pokemon {

	@EmbeddedId
	private Pedido_PokemonPK id = new Pedido_PokemonPK();
	private LocalDate dataCriacao;

	public Pedido_Pokemon(Pedido pedido, Pokemon pokemon, LocalDate dataCriacao) {
		super();
		this.id.setPedido(pedido);
		this.id.setPokemon(pokemon);
		this.dataCriacao = dataCriacao;
	}

	public Pedido_PokemonPK getid() {
		return id;
	}

	public Pedido_PokemonPK getId() {
		return id;
	}

	public void setId(Pedido_PokemonPK id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
