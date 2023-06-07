package com.petclinic.pet.Services;

import com.petclinic.pet.Models.Owner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="owner-service",url = "http://localhost:8090/owners")
public interface OwnerServiceProxy {

    @GetMapping("/ownerById/{id}")
    public Owner getOwnerById(@PathVariable("id") Long id  );

}
