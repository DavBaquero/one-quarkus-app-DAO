package edu.badpals.quarkus.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ord_id")
        private long id;

        @ManyToOne
        @JoinColumn(name = "ord_user")
        private Usuaria user;

        @OneToOne
        @JoinColumn(name = "ord_item")
        private Item item;

        public Orden() {
        }

        public Orden(Usuaria user, Item item) {
            this.user = user;
            this.item = item;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Usuaria getUser() {
            return user;
        }

        public void setUser(Usuaria user) {
            this.user = user;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return this.getUser().getNombre() + " " + this.getItem().getNombre();
        }

        
        
}
