package br.com.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.LancamentoRepository;
import jakarta.validation.Valid;

@Service
public class LancamentoVendasService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public LancamentoVendasMostrarDTO buscarPorID(Long id) {
        LancamentoVendas lv = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("lancamento não encontrado!"));
        return new LancamentoVendasMostrarDTO(lv.getDataVenda(), lv.getValorVenda(),lv.getVendedor().getNome());
    }
	
	public LancamentoVendas inserirLancamento(@RequestBody LancamentoVendas venda) {
		return repository.save(venda);
	}
	
	public List<LancamentoVendasMostrarDTO> listar(){
		List<LancamentoVendas> lv=repository.findAll();
		return lv.stream().map( (lancamento)->  new LancamentoVendasMostrarDTO( 
                lancamento.getDataVenda(),lancamento.getValorVenda(),
                lancamento.getVendedor().getNome())).collect(Collectors.toList());
	}
	
	public ResponseEntity<Void> deletar(Long id) {
		repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("lancamento não encontrado!"));
		repository.deleteById(id);
		return ResponseEntity.notFound().build();
	}
	
	public LancamentoVendasMostrarDTO alterarLancamento(LancamentoVendas lv){
        repository.save(lv);
        return new LancamentoVendasMostrarDTO(lv.getDataVenda(), lv.getValorVenda(), lv.getVendedor().getNome());
    }
}
