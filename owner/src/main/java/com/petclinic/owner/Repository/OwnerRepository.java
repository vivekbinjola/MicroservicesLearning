package com.petclinic.owner.Repository;

import com.petclinic.owner.models.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Owner is the model that we want in the repo and Long is the
//datatype of the primary key
@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

}
