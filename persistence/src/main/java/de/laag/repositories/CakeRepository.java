package de.laag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.laag.entities.Cake;

public interface CakeRepository extends JpaRepository<Cake, Long> {}
