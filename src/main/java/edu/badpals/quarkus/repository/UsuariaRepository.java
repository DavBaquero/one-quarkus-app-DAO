package edu.badpals.quarkus.repository;

import edu.badpals.quarkus.dominio.Usuaria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuariaRepository implements PanacheRepositoryBase<Usuaria, String>{
    
}
