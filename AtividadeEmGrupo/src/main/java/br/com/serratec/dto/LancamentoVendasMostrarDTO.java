package br.com.serratec.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LancamentoVendasMostrarDTO {

	private LocalDateTime dataVenda;
	private BigDecimal valorVenda;
	private String nome;
	
	public LancamentoVendasMostrarDTO(LocalDateTime dataVenda, BigDecimal valorVenda, String nome) {
		super();
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.nome = nome;
	}
		
	public LocalDateTime getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDateTime dataVenda) {
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
