package br.com.rocketStore.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Endereco;

public class ClienteResponseDTO {

	private String nome;
	private String email;
	private String CPF;
	private List<String> telefones = new ArrayList<>();
	private List<Endereco> enderecos = new ArrayList<>();

	public ClienteResponseDTO(Cliente cliente) {
		nome = cliente.getNome();
		telefones = cliente.getTelefones();
		email = cliente.getEmail();
		CPF = cliente.getCPF();
		enderecos = cliente.getEnderecos();
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

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
