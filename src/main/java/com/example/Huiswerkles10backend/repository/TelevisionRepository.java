package com.example.Huiswerkles10backend.repository;

import com.example.Huiswerkles10backend.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    void deleteByNameContaining(String name);

    Optional<Television> findByName (String name);
}
