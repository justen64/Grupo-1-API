package br.com.rocketStore.DTO;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;

public class ClienteRequestDTO {
	private String nome;
	private String telefone1;
	private String telefone2;
	private String email;
	private String cpf;
	private String senha;
	private String confirmaSenha;
	private Endereco endereco;
	
	public ClienteRequestDTO() {
		super();
	}

	public ClienteRequestDTO(Cliente cliente) {
		nome = cliente.getNome();
		telefone1 = cliente.getTelefone1();
		telefone1 = cliente.getTelefone2();
		email = cliente.getEmail();
		cpf = cliente.getCpf();
		senha = cliente.getSenha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}