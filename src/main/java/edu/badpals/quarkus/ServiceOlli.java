package edu.badpals.quarkus;

import java.util.Optional;

import edu.badpals.quarkus.dominio.*;
import edu.badpals.quarkus.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceOlli {

    @Inject
    public UsuariaRepository usuariaRepo;
    
    public ServiceOlli(){}

    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = usuariaRepo.findByIdOptional(nombre);
        return user.isPresent() ? user.get() : new Usuaria();
    }

    public Usuaria creaUsuaria(Usuaria user){
        usuariaRepo.persist(user);
        return this.cargaUsuaria(user.getNombre());
    }
}
