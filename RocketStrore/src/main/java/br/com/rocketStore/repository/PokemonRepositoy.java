package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Pokemon;

public interface PokemonRepositoy extends JpaRepository<Pokemon, Long>{

}
