package com.example.demo.entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @EmbeddedId
    private CustomerId id;

    private String name;
    private String email;

    public Customer() {}

    public Customer(CustomerId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters

    public CustomerId getId() {
        return id;
    }

    public void setId(CustomerId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
