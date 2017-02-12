package de.laag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.laag.repositories.CakeRepository;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;
}
