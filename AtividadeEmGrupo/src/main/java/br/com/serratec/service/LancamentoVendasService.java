package br.com.serratec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasMostrarDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.exception.VendasException;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoVendasService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public LancamentoVendasMostrarDTO buscarPorID(Long id) {
		
	}
	
	public LancamentoVendas inserir(LancamentoVendas lv){
        if (repository.findByDataVenda(lv.getDataVenda()) != null|repository.findByNome(lv.getVendedor().getNome()) != null ) {
            throw new VendasException();
        }
        return repository.save(lv);
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
	
//	public List<VendedorResponseDTO>
}
