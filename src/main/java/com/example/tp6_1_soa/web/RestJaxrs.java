package com.example.tp6_1_soa.web;

import com.example.tp6_1_soa.entities.Compte;
import com.example.tp6_1_soa.repositories.CompteRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class RestJaxrs {
    @Autowired
    private CompteRepository cmt_rep;

    @GET
    @Path("/comptes")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public List<Compte> comptelist(){
        return cmt_rep.findAll();}
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id){
        return cmt_rep.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return cmt_rep.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte,@PathParam("id") Long id){
        compte.setId(id);
        return cmt_rep.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        cmt_rep.deleteById(id);
    }
}



