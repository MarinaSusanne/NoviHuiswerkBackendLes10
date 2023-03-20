package com.example.Huiswerkles10backend.dtos.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CIModuleInputDto {
    public Long id;
    @NotNull(message = "name is required")
    public String name;
    public String type;
    @Positive
    public Double price;

}
