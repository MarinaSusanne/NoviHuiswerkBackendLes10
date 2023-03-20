package com.example.Huiswerkles10backend.dtos.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class WallBracketInputDto {
    public Long id;
    public String size;
    public Boolean adjustable;
    @NotNull (message = "name is required")
    public String name;
    @Positive
    public Double price;

}
