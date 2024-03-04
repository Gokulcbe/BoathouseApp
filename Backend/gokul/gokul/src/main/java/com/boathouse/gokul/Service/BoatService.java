package com.boathouse.gokul.Service;

import java.util.List;

import com.boathouse.gokul.dto.BoatDTO;

public interface BoatService {
    BoatDTO createBoat(BoatDTO boatDTO);

    BoatDTO updateBoat(BoatDTO boatDTO);

    String deleteBoatById(Long id);

    BoatDTO getBoatById(Long id);

    List<BoatDTO> getAllBoats();
} 
