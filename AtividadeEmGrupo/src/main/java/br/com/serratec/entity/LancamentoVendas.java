package br.com.serratec.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LancamentoVendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVenda;
	private LocalDateTime dataVenda;
	private BigDecimal valorVenda;
	
	@ManyToOne
	@JoinColumn(name = "codigoVendedor")
	private Vendedor vendedor;

	

	public Long getCodigoVenda() {
		return codigoVenda;
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


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
