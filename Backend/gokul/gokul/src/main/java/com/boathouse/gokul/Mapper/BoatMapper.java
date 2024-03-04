package com.boathouse.gokul.Mapper;

import com.boathouse.gokul.Model.Boat;
import com.boathouse.gokul.dto.BoatDTO;

public class BoatMapper {
    public static BoatDTO mapToBoatDTO(Boat boat){
        return new BoatDTO(
            boat.getId(),
            boat.getBoattype(),
            boat.getCapacity(),
            boat.getIncharge(),
            boat.getPrice()
        );
    }

    public static Boat mapToBoat(BoatDTO boatDTO){
        return new Boat(
            boatDTO.getId(),
            boatDTO.getBoattype(),
            boatDTO.getCapacity(),
            boatDTO.getIncharge(),
            boatDTO.getPrice()
        );
    }
}
