package br.com.rocketStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.rocketStore.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
	 @Query(value = "SELECT curiosidade FROM Pokemon", nativeQuery = true)
	List<String> findAllCuriosidades();
}
