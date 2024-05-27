package br.com.rocketStore.DTO;

import java.time.LocalDate;

import br.com.rocketStore.entity.Cliente;
import br.com.rocketStore.entity.Pedido;
import br.com.rocketStore.enuns.StatusENUM;
import br.com.rocketStore.exception.ClienteException;

public class PedidoResponseDTO {

	private LocalDate dataPedido;
	private StatusENUM status;
	private ClienteResponseDTO cliente;

	public PedidoResponseDTO(Pedido pedido) {
		this.dataPedido = pedido.getDataPedido();
		this.status = pedido.getStatus();
		if (pedido.getCliente() != null) {
			this.cliente = new ClienteResponseDTO(pedido.getCliente());
		} else {
			throw new ClienteException("Cliente do pedido " + pedido.getId().toString() + " rebebido é nulo.");
		};
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

	public ClienteResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}

}
