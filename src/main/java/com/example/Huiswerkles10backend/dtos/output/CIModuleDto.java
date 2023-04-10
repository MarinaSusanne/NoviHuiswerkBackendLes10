package com.example.Huiswerkles10backend.dtos.output;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
//output dto's hebben geen validatie regels

public class CIModuleDto {
    public Long id;
    public String name;
    public String type;
    public Double price;

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
}
