package com.petclinic.owner.controllers;

import com.petclinic.owner.Repository.OwnerRepository;
import com.petclinic.owner.Service.OwnerService;
import com.petclinic.owner.models.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OwnerController {
    Logger logger = LoggerFactory.getLogger(OwnerController.class);

    @Value("${message: mymessage}")
    private String message;

    @Autowired
    OwnerService ownerService;



    @GetMapping("/all")
    public List<Owner> getAllOwners(){
       return this.ownerService.getAllOwners();
    }

    @GetMapping("/message")
    public String getMessage(){
        return this.message;
    }

    @PostMapping("/add")
    public Owner insertOwner(@RequestBody Owner owner){
        return this.ownerService.insertOwner(owner);
    }

    @GetMapping("/ownerById/{id}")
    public Owner getOwnerById(@PathVariable("id") Long id  ){
        return this.ownerService.getOwnerById(id);
    }

    @PutMapping("/updateOwner")
    public ResponseEntity<Owner> updateOwner( @RequestBody Owner owner){
        Owner existingOwner = this.ownerService.getOwnerById(owner.getId());

        if(existingOwner != null){

            Owner updatedOwner = this.ownerService.updateOwner(existingOwner);

            return new ResponseEntity("Owner Updated",HttpStatus.ACCEPTED);

        }else{
            return new ResponseEntity("Owner not found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteOwner/{id}")
    public ResponseEntity<Owner> deleteOwner(@PathVariable Long id ){
        Boolean delete = this.ownerService.deleteOwner(id);
        HttpStatus status;
        String msg;

        if(delete){
            status = HttpStatus.OK;
            msg = "deleted successfully";
        }else {
            status = HttpStatus.NOT_FOUND;
            msg = "user not found";
        }

        return new ResponseEntity(msg,status);
    }
}
