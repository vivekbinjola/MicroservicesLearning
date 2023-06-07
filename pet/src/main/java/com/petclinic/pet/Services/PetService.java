package com.petclinic.pet.Services;

import com.petclinic.pet.Models.Pet;
import com.petclinic.pet.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {


    @Autowired
    private PetRepository petRepository;


    public Pet add(Pet pet) {

        return petRepository.save(pet);
    }

    public Pet get(Long id) {

        Optional optional = petRepository.findById(id);

        Pet result = null;
        if (optional.isPresent()) {
            result = (Pet) optional.get();
        }
        return result;
    }

    public Pet modify(Pet pet) {

        return petRepository.save(pet);
    }

    public void delete(Long id) {

        Pet petToDelete = get(id);
        this.petRepository.delete(petToDelete);

    }

    public List<Pet> getAll() {

        return (List<Pet>) petRepository.findAll();
    }


    public List<Pet> getPetByName(String name) {

        return this.petRepository.getPetByName(name);
    }


}
