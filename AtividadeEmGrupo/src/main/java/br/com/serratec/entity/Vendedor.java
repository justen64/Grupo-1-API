package br.com.serratec.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVendedor;
	
	@NotBlank(message = "Nome vazio ou nulo!")
	private String nome;
	
	@Email
	private String email;
	
	@DecimalMin(value = "1412", message = "Valor inferior ao salário minímo")
	private BigDecimal salario;
	private BigDecimal comissao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "vendedor")
	private List<LancamentoVendas> vendas = new ArrayList<>();
	
	
	
	
	
	public List<LancamentoVendas> getVendas() {
		return vendas;
	}
	public void setVendas(List<LancamentoVendas> vendas) {
		this.vendas = vendas;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	
	
}
