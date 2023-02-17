package com.harry.travels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.harry.travels.models.Travel;

import java.util.List;

public interface TravelRepository extends CrudRepository<Travel,Long>{
    List<Travel> findAll();
}
 