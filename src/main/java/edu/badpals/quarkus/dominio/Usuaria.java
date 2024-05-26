package edu.badpals.quarkus.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_users")
public class Usuaria extends PanacheEntityBase{
    @Id
        @Column(name = "user_nom")
        private String nombre;

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
