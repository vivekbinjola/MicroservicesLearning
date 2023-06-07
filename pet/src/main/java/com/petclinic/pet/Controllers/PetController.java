package com.petclinic.pet.Controllers;

import com.petclinic.pet.Models.Owner;
import com.petclinic.pet.Models.Pet;
import com.petclinic.pet.Models.PetWithOwner;
import com.petclinic.pet.Services.OwnerServiceProxy;
import com.petclinic.pet.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private OwnerServiceProxy ownerServiceProxy;


    @PostMapping(value = "addPet", produces = "application/json")
    public Pet add(@RequestBody Pet pet) {

        return this.petService.add(pet);
    }


    @GetMapping(value = "getPetById/{id}", produces = "application/json")
    public PetWithOwner get(@PathVariable("id") Long id) {
        PetWithOwner petWithOwner = new PetWithOwner();
        Pet pet = this.petService.get(id);
        petWithOwner.setPet(pet);

        Owner owner = ownerServiceProxy.getOwnerById(petWithOwner.getOwnerId());
        petWithOwner.setOwner(owner);
        return petWithOwner;
    }


    @PutMapping(value = "updatePet", produces = "application/json")
    public Pet modify(@RequestBody Pet pet) {

        return this.petService.modify(pet);
    }


    @DeleteMapping(value = "deletePet/{id}", produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        this.petService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(value = "getAllPets", produces = "application/json")
    public List<Pet> getAll() {

        return this.petService.getAll();

    }

    @GetMapping(value = "getPetByName/{name}", produces = "application/json")
    public List<Pet> getPetByName(@PathVariable String name) {

        return this.petService.getPetByName(name);
    }
}
