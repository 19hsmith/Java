package com.harry.travels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harry.travels.repositories.TravelRepository;
import java.util.List;
import java.util.Optional;

import com.harry.travels.models.Travel;

@Service
public class TravelService {

    @Autowired TravelRepository travelRepository;

    public List<Travel> allTravel(){
        return travelRepository.findAll();
    }
    public void createTravel(Travel travel){
        travelRepository.save(travel);
    }
    public Travel getOneTravel(Long id){
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        return optionalTravel.orElse(null);
    }
    public void updateTravel(Travel travel){
        travelRepository.save(travel);
    }
    public void deleteTravel(Travel travel) {
        travelRepository.delete(travel);
    }
}
