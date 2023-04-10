package com.example.Huiswerkles10backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="ci-Modules")
public class CIModule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double price;

//target kant van de relatie.
    @OneToMany(mappedBy = "ciModule")
    @JsonIgnore
    private List<Television> televisions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }
}
