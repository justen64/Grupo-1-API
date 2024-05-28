package br.com.rocketStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column
	private String nome;
	
	private Long ordem;
	
	@Embedded
	private Types types;
	
	@Embedded
	private Sprites sprites;;

	private Double valorUnitario;
	
	

	public Pokemon() {
		super();
	}

	public Pokemon( String nome, Long ordem, Types types, Sprites sprites) {
		super();
		this.nome = nome;
		this.ordem = ordem;
		this.types = types;
		this.sprites = sprites;
		
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}


	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}	
	
	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	
}
