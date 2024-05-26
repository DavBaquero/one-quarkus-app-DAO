package edu.badpals.quarkus.repository;

import edu.badpals.quarkus.dominio.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepositoryBase<Item, String>{
    
}
