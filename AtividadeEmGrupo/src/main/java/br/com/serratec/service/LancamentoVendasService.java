package br.com.serratec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoVendasService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public LancamentoVendasMostrarDTO buscar(Long id) {
		LancamentoVendas lv = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("lancamento não encontrado!"));
		return new LancamentoVendasMostrarDTO(lv.getDataVenda(), lv.getValorVenda(),lv.getVendedor().getNome());
	}
	
	public LancamentoVendasMostrarDTO inserir(LancamentoVendas venda) {
		LancamentoVendas lv = repository.findBy(venda).orElseThrow(()-> new ResourceNotFoundException("lancamento não encontrado!"));
		return new LancamentoVendasMostrarDTO(lv.getDataVenda(), lv.getValorVenda(),lv.getVendedor().getNome());
	}
//	public List<VendedorResponseDTO>
}
