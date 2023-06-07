package com.petclinic.pet.Repository;

import com.petclinic.pet.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> getPetByName(String name);
}
