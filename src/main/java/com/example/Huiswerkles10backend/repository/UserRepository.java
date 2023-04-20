package com.example.Huiswerkles10backend.repository;


import com.example.Huiswerkles10backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
