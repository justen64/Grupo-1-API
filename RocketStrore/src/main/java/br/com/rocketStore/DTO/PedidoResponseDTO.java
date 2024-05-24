package br.com.rocketStore.DTO;

import java.time.LocalDate;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.enuns.StatusENUM;

public class PedidoResponseDTO {

	private LocalDate dataPedido;
	private StatusENUM status;
	private Cliente cliente;

	public PedidoResponseDTO(Pedido pedido) {
		this.dataPedido = pedido.getDataPedido();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusENUM getStatus() {
		return status;
	}

	public void setStatus(StatusENUM status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
