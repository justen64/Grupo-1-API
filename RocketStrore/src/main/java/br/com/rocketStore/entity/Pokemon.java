package br.com.rocketStore.entity;

import java.time.LocalDate;

import br.com.rocketStore.enuns.TipoENUM;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotBlank
	private String nome;
	private LocalDate dataCadastro;
	private LocalDate alteradoEm;
	@NotBlank
	private Long pokedexId;
	private String descricao;
	@NotBlank
	private Double valor;
	@NotBlank
	private TipoENUM tipoPrimario;
	private TipoENUM tipoSecundario;
	
	
	
	public TipoENUM getTipoPrimario() {
		return tipoPrimario;
	}
	public void setTipoPrimario(TipoENUM tipoPrimario) {
		this.tipoPrimario = tipoPrimario;
	}
	public TipoENUM getTipoSecundario() {
		return tipoSecundario;
	}
	public void setTipoSecundario(TipoENUM tipoSecundario) {
		this.tipoSecundario = tipoSecundario;
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
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getAlteradoEm() {
		return alteradoEm;
	}
	public void setAlteradoEm(LocalDate alteradoEm) {
		this.alteradoEm = alteradoEm;
	}
	public Long getPokedexId() {
		return pokedexId;
	}
	public void setPokedexId(Long pokedexId) {
		this.pokedexId = pokedexId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
