package de.laag.repositories;

import de.laag.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

import de.laag.entities.User;

public interface CakeRepository extends JpaRepository<Cake, Long> {}
