package com.petclinic.owner.Service;

import com.petclinic.owner.Repository.OwnerRepository;
import com.petclinic.owner.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

@Autowired
private OwnerRepository ownerRepository;

public OwnerService(OwnerRepository ownerRepository){
    this.ownerRepository = ownerRepository;
}

public List<Owner> getAllOwners(){
    return this.ownerRepository.findAll();
}

public Owner insertOwner(Owner owner){
    return this.ownerRepository.save(owner);
}

public Owner getOwnerById(long id ){

    return this.ownerRepository.findById(id).orElse(null);

}

public Owner updateOwner(Owner owner){
    return this.ownerRepository.save(owner);
}

public boolean deleteOwner(Long id){
    try {
        this.ownerRepository.deleteById(id);
        return true;
    }catch(Exception e){
        return false;
    }
}
}
