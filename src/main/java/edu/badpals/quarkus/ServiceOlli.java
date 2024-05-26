package edu.badpals.quarkus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

import edu.badpals.quarkus.dominio.*;
import edu.badpals.quarkus.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    public void Usuaria(String user){
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

    @Transactional
    public Orden comanda(String nom_usu, String item_nom){
        Orden orden = null;
        Optional<Usuaria> user = usuariaRepo.findByIdOptional(nom_usu);
        Optional<Item> item = itemRepo.findByIdOptional(item_nom);

        if(user.isPresent() && item.isPresent() 
            && user.get().getDestreza() >= item.get().getQuality()){
            orden = new Orden(user.get(), item.get());
            ordenRepo.persist(orden);
        }

        return orden;
    }

    @Transactional
    public List<Orden> comandaMultiple(String usur_nom, List<String> productos){
        Optional<Usuaria> user = usuariaRepo.findByIdOptional(usur_nom);
        if(user.isEmpty()){
            return Collections.emptyList();
        }

        List<Orden> ordenes = new ArrayList<Orden>();

        Orden orden = null;
        for(String producto: productos){
            orden = this.comanda(user.get().getNombre(), producto);
            if (orden != null){
                ordenes.add(orden);
            }
        }
        return ordenes;
    }
}
