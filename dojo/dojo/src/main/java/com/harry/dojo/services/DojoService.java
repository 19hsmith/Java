package com.harry.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harry.dojo.models.Dojo;
import com.harry.dojo.repositories.DojoRepository;

@Service
public class DojoService {
    @Autowired DojoRepository dojoRepository;

    public List <Dojo> getAll(){
        return dojoRepository.findAll();
    }

    public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    public Dojo getDojo(Long id){
        Optional<Dojo>optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }
}
