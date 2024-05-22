package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;
import br.com.rocketStore.entity.Telefone;

public class ClienteResponseDTO {

	private String nome;
	private Telefone telefone;
	private String email;
	private String CPF;
	private Endereco endereco;
	
	public ClienteResponseDTO(Cliente cliente) {
		nome = cliente.getNome();
		telefone = cliente.getTelefone();
		email = cliente.getEmail();
		CPF = cliente.getCPF();
		endereco = cliente.getEndereco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
