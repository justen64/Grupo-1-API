package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Time_Pokemon;
import br.com.rocketStore.pk.Time_PokemonPK;

public interface Time_PokemonRepository extends JpaRepository<Time_Pokemon, Time_PokemonPK>{

}
