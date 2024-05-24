package br.com.rocketStore.DTO;

import java.util.List;

import br.com.rocketStore.entity.Types;

public class PokemonDTO {

private String name;
	
	private Long id;
	
	private List<TypesDTO> types;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TypesDTO> getTypes() {
		return types;
	}

	public void setTypes(List<TypesDTO> types) {
		this.types = types;
	}

	
	
	
	
}
