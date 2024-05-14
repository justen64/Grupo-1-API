package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Long>{

}
