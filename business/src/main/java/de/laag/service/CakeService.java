package de.laag.service;

import de.laag.entities.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.laag.repositories.CakeRepository;

import java.util.List;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public Cake getCake(Long id) {
        return cakeRepository.findOne(id);
    }
}
