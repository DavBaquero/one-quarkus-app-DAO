package edu.badpals.quarkus;

import java.util.Optional;

import edu.badpals.quarkus.dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceOlli {
    
    public ServiceOlli(){}

    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = Usuaria.findByIdOptional(nombre);
        return user.isPresent() ? user.get() : new Usuaria();
    }
}
