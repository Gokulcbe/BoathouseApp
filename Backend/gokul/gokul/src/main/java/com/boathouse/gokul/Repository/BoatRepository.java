package com.boathouse.gokul.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boathouse.gokul.Model.Boat;

public interface BoatRepository extends JpaRepository<Boat, Long>{
    
}
