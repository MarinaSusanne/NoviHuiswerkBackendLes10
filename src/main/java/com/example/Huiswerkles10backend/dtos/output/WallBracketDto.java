package com.example.Huiswerkles10backend.dtos.output;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class WallBracketDto{
        public Long id;
        public String size;
        public Boolean adjustable;
        public String name;
        public Double price;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getSize() {
                return size;
        }

        public void setSize(String size) {
                this.size = size;
        }

        public Boolean getAdjustable() {
                return adjustable;
        }

        public void setAdjustable(Boolean adjustable) {
                this.adjustable = adjustable;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }
}
