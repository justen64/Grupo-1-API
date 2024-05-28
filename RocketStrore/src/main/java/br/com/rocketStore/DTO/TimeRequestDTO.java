package br.com.rocketStore.DTO;

import java.util.HashSet;
import java.util.Set;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Time;

public class TimeRequestDTO {

	private Cliente cliente;
	private Set<Pokemon> pokemon = new HashSet<>();
	private String descricao;
	
	public TimeRequestDTO() {
		super();
	}

	public TimeRequestDTO(Time time, Set<Pokemon> pokemon) {
		this.cliente = time.getCliente();
		this.pokemon = pokemon;
		this.descricao = time.getDescricao();
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(Set<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
