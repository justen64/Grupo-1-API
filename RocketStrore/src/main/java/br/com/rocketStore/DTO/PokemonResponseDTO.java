package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Sprites;

public class PokemonResponseDTO {

	private String name;

	private Long pokeDex;

	private String tipoPrimario;

	private String tipoSecundario;

	private Double valorUnitario;
	
	private Sprites sprites;

	public PokemonResponseDTO() {
		super();
	}

	public PokemonResponseDTO(Pokemon pokemon) {
		super();
		this.name = pokemon.getNome();
		this.pokeDex = pokemon.getOrdem();
		this.tipoPrimario = pokemon.getTypes().getName1();
		this.tipoSecundario = pokemon.getTypes().getName2();
		this.valorUnitario = pokemon.getValorUnitario();
		this.sprites = pokemon.getSprites();
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPokeDex() {
		return pokeDex;
	}

	public void setPokeDex(Long pokeDex) {
		this.pokeDex = pokeDex;
	}

	public String getTipoPrimario() {
		return tipoPrimario;
	}

	public void setTipoPrimario(String tipoPrimario) {
		this.tipoPrimario = tipoPrimario;
	}

	public String getTipoSecundario() {
		return tipoSecundario;
	}

	public void setTipoSecundario(String tipoSecundario) {
		this.tipoSecundario = tipoSecundario;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
