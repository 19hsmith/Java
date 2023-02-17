package com.harry.dojo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harry.dojo.models.Ninja;
import com.harry.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
    @Autowired NinjaRepository  ninjaRepository;

    public void createNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}
