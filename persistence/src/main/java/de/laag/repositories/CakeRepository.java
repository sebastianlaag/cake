package de.laag.repositories;

import org.springframework.data.repository.CrudRepository;

import de.laag.entities.Cake;

public interface CakeRepository extends CrudRepository<Cake, Long> {}
