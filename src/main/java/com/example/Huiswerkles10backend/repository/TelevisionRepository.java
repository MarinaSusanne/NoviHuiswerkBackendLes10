package com.example.Huiswerkles10backend.repository;

import com.example.Huiswerkles10backend.model.Television;
import com.example.Huiswerkles10backend.services.TelevisionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleBiFunction;

//constructor injection
public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
