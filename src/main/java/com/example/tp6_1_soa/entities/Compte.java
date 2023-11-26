package com.example.tp6_1_soa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Getter  @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double solde;
    Date DateCreation;
    TypeCompte type;

}