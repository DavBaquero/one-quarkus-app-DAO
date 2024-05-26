package edu.badpals.quarkus.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_users")
public class Usuaria{
    @Id
        @Column(name = "user_nom", unique = true)
        private String nombre = "";

        @Column(name = "user_prop")
        private int destreza;

        public Usuaria() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getDestreza() {
            return destreza;
        }

        public void setDestreza(int destreza) {
            this.destreza = destreza;
        }

        
}
