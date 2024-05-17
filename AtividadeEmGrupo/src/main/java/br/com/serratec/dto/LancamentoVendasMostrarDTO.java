package br.com.serratec.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoVendasMostrarDTO {

	private LocalDate dataVenda;
	private BigDecimal valorVenda;
	private String nome;
	
	public LancamentoVendasMostrarDTO(LocalDate dataVenda, BigDecimal valorVenda, String nome) {
		super();
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.nome = nome;
	}
		
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
