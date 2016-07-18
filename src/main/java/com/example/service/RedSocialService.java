package com.example.service;

import com.example.domain.Amistad;
import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.AmistadRepository;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service // Servicio
@Transactional
public class RedSocialService {
    // Declaramos los repositorios necesarios
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;
    @Autowired
    private AmistadRepository amistadRepository;


    public void anadirPersona(Persona persona) {

        personaRepository.save(persona);

    }

    public void anadirPareja (Persona persona1, Persona persona2) {

        Pareja pareja = new Pareja(persona1, persona2);
        parejaRepository.save(pareja);
    }

    public Amistad anadirAmistad(Persona persona1, Persona persona2) {

        return amistadRepository.save(new Amistad(persona1, persona2));

    }

    public Persona obtenerPersona (Long id) {

        return personaRepository.findOne(id);
    }

    public Persona obtenerPersona (String nombre) {

        return personaRepository.findByNombre(nombre);
    }

    public Persona obtenerPareja (Persona persona) {

        Pareja pareja = parejaRepository.obtenerPareja(persona);

        Persona resultado = null;

        if (pareja == null) {

            return resultado;

        } else {

            if (pareja.getPersona1().equals(persona)) {

                resultado = pareja.getPersona2();

            } else if (pareja.getPersona2().equals(persona)) {

                resultado = pareja.getPersona1();
            }
        }

        return resultado;
    }

    public List<Persona> obtenerAmistades(Persona persona) { // devuelve una Lista de Persona

        List<Amistad> amistades = amistadRepository.obtenerAmistades(persona);

        List<Persona> resultado = new ArrayList<>();

        for (Amistad amistad : amistades) {

            if (amistad.getPersona1().equals(persona)) {

                resultado.add(amistad.getPersona2());

            } else if (amistad.getPersona2().equals(persona)) {

                resultado.add(amistad.getPersona1());
            }
        }

        return resultado;
    }
}
