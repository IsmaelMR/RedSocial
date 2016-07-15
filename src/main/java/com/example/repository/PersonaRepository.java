package com.example.repository;

import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona,Long> { // Repositorio de PERSONA

    Persona findByNombre(String nombre);

    List<Persona> findByNombreAndApellido(String nombre, String apellido);

    List<Persona> findByNombreOrApellido(String nombre, String apellido);

    List<Persona> findByEdadGreaterThanEqual(Integer edad);

}
