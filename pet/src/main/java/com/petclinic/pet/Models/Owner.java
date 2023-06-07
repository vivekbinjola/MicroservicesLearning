package com.petclinic.pet.Models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Owner {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String phoneNo;


}
