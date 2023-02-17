package com.harry.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.harry.dojo.models.Dojo;

public interface DojoRepository  extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();
    
}
