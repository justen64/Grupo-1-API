package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Cliente;

public class ClienteRequestDTO {
	private String nome;
	private String telefone1;
	private String telefone2;
	private String email;
	private String CPF;
	private String cep;
	private String senha;
	private String confirmaSenha;

	public ClienteRequestDTO(Cliente cliente) {
		nome = cliente.getNome();
		telefone1 = cliente.getTelefone1();
		telefone1 = cliente.getTelefone2();
		email = cliente.getEmail();
		CPF = cliente.getCPF();
		cep = cliente.getCep();
		senha = cliente.getSenha();
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}