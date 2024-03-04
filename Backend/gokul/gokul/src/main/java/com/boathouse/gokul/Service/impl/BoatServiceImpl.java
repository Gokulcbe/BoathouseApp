package com.boathouse.gokul.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boathouse.gokul.Exception.ResourceNotFoundException;
import com.boathouse.gokul.Mapper.BoatMapper;
import com.boathouse.gokul.Model.Boat;
import com.boathouse.gokul.Repository.BoatRepository;
import com.boathouse.gokul.Service.BoatService;
import com.boathouse.gokul.dto.BoatDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoatServiceImpl implements BoatService {

    private BoatRepository boatrepo;

    @Override
    public BoatDTO createBoat(BoatDTO boatDTO){
        Boat boat = BoatMapper.mapToBoat(boatDTO);
        Boat savedBoat = boatrepo.save(boat);
        return BoatMapper.mapToBoatDTO(savedBoat);
    }

    @Override
    public BoatDTO updateBoat(BoatDTO boatDTO){
        Boat boat = BoatMapper.mapToBoat(boatDTO);
        Boat savedBoat = boatrepo.saveAndFlush(boat);
        return BoatMapper.mapToBoatDTO(savedBoat);
    }

    @Override
    public String deleteBoatById(Long id){
        boatrepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public BoatDTO getBoatById(Long id) {
        Boat boat = boatrepo.findById(id)
                    .orElseThrow(
                        () -> new ResourceNotFoundException("user is not exist with given email : " +  id));
        return BoatMapper.mapToBoatDTO(boat);       
    }

    @Override
    public List<BoatDTO> getAllBoats() {
       List<Boat> boats = boatrepo.findAll();
       List<BoatDTO> boatDTOs = new ArrayList<>();
       for(Boat boat : boats){
            boatDTOs.add(BoatMapper.mapToBoatDTO(boat));
       }
       return boatDTOs;
    }


}

