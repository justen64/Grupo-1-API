	package br.com.rocketStore.entity;
	
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.OneToMany;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.NotNull;
	
	@Entity
	public class Time {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id;
		public String descricao;
		
		@ManyToOne
	//	@NotBlank(message = "Cliente não inserido")
		@NotNull
		@JoinColumn(name = "id_cliente")
		public Cliente cliente;
		
		
		@OneToMany(mappedBy = "id.time", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//	@NotBlank(message = "Pokemons não inseridos")	
		@NotNull
		private Set<Time_Pokemon> pokemons = new HashSet<>();
		
		public String getDescricao() {
			return descricao;
		}
	
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	
		public Cliente getCliente() {
			return cliente;
		}
	
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public Set<Time_Pokemon> getPokemons() {
			return pokemons;
		}
		
		public void setPokemons(Set<Time_Pokemon> pokemons) {
		    if (pokemons.size() <= 6) {
		        this.pokemons = pokemons;
		    } else {
		        throw new IllegalArgumentException("O time não pode ter mais de 6 pokémons");
		    }
		}
	
	
	}
