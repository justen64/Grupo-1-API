package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Cliente;

public class ClienteResponseDTO {

	private String nome;
	private String email;
	private String CPF;
	private String telefone1;
	private String telefone2;
	private EnderecoDTO endereco;

	public ClienteResponseDTO(Cliente cliente, EnderecoDTO endereco) {
		nome = cliente.getNome();
		telefone1 = cliente.getTelefone1();
		telefone2 = cliente.getTelefone2();	
		email = cliente.getEmail();
		CPF = cliente.getCPF();
		this.endereco = endereco;
	}

	public ClienteResponseDTO() {
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}



}
