package br.com.serratec.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.LancamentoVendas;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long>{
	
	LancamentoVendas findByDataVenda(LocalDateTime localDateTime);
	LancamentoVendas findByValorVenda(BigDecimal valorVenda);
}
