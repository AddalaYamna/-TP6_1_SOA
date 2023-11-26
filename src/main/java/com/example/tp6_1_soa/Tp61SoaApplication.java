package com.example.tp6_1_soa;

import com.example.tp6_1_soa.entities.Compte;
import com.example.tp6_1_soa.entities.EtatCompte;
import com.example.tp6_1_soa.entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.tp6_1_soa.repositories.CompteRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
public class Tp61SoaApplication{

    public static void main(String[] args) {
        SpringApplication.run(Tp61SoaApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository cmt_rep){
        return args -> {
            cmt_rep.save(new Compte(null, 30.0, new Date(), TypeCompte.EPARGNE));
            cmt_rep.save(new Compte(null, 70.0, new Date(), TypeCompte.COURANT));
            cmt_rep.save(new Compte(null, 58.0, new Date(), TypeCompte.EPARGNE));
            cmt_rep.findAll().forEach(c ->{
                System.out.println(c.getSolde());
            });
        };
    }

}