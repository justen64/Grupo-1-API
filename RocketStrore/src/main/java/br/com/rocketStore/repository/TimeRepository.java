package br.com.rocketStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketStore.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
