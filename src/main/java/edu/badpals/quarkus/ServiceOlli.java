package edu.badpals.quarkus;

import java.util.List;
import java.util.Optional;


import edu.badpals.quarkus.dominio.*;
import edu.badpals.quarkus.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceOlli {

    @Inject
    public UsuariaRepository usuariaRepo;

    @Inject
    public ItemRepository itemRepo;

    @Inject
    public OrdenRepository ordenRepo;
    
    public ServiceOlli(){}

    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = usuariaRepo.findByIdOptional(nombre);
        return user.isPresent() ? user.get() : new Usuaria();
    }

    public Usuaria creaUsuaria(Usuaria user){
        usuariaRepo.persist(user);
        return this.cargaUsuaria(user.getNombre());
    }

    public void deleteUsuaria(String user){
        usuariaRepo.deleteById(user);
    }

    public Item cargaItem(String nombre){
        Optional<Item> item = itemRepo.findByIdOptional(nombre);
        return item.isPresent() ? item.get() : new Item();
    }

    public List<Orden> cargaOrden(String nom_user){
        return ordenRepo.findByUserName(nom_user);
    }

    public List<Orden> ordenes(){
        return ordenRepo.listAll();
    }
}
