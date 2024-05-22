package br.com.rocketStore.entity;

import jakarta.persistence.Entity;

@Entity
public class Telefone {

	private String DDD;
	private String NumeroTelefone;
	private String Prefixo;

	
	public String getDDD() {
		return DDD;
	}	
	public void setDDD(String dDD) {
		DDD = dDD;
	}
	public String getNumeroTelefone() {
		return NumeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		NumeroTelefone = numeroTelefone;
	}
	public String getPrefixo() {
		return Prefixo;
	}
	public void setPrefixo(String prefixo) {
		Prefixo = prefixo;
	}

	@Override
	public String toString() {
		return "Telefone [DDD=" + DDD + ", NumeroTelefone=" + NumeroTelefone + ", Prefixo=" + Prefixo + "]";
	}
	
}
