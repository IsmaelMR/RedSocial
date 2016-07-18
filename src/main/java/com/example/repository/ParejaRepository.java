package com.example.repository;

import com.example.domain.Pareja;
import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParejaRepository extends JpaRepository<Pareja,Long> { // Repositorio de PAREJA

    @Query("SELECT pareja FROM Pareja pareja WHERE pareja.persona1 = :persona OR pareja.persona2 = :persona")
    Pareja obtenerPareja(@Param("persona") Persona persona);
}
