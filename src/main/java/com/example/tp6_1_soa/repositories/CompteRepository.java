package com.example.tp6_1_soa.repositories;

import com.example.tp6_1_soa.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository <Compte, Long> {

}