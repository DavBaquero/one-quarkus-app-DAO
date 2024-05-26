package edu.badpals.quarkus.repository;

import java.util.List;
import java.util.stream.Collectors;

import edu.badpals.quarkus.dominio.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdenRepository implements PanacheRepository<Orden>{
    public List<Orden> findByUserName(String nom_user){
        List<Orden> ordenes = this.listAll().stream()
                                            .filter(o -> o.getUser().getNombre().equalsIgnoreCase(nom_user))
                                            .collect(Collectors.toList());
        return ordenes.isEmpty()? List.of(): ordenes;
    }
}
