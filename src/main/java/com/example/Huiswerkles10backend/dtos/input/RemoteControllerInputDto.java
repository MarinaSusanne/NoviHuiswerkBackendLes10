package com.example.Huiswerkles10backend.dtos.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public class RemoteControllerInputDto {
    public Long id;
    public String compatibleWith;
    public String batteryType;
    @NotNull(message = "name is required")
    public String name;
    public String brand;
    @Positive
    public Double price;
    public Integer originalStock;
}
