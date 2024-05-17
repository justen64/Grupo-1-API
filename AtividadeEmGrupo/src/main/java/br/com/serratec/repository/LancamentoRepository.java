package br.com.serratec.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.LancamentoVendas;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long>{
	
	LancamentoVendas findByDataVenda(LocalDate dataVenda);
	LancamentoVendas findByValorVenda(BigDecimal valorVenda);
	LancamentoVendas findByNome(String nome);
}
