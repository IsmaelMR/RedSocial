package com.example.service;

import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Servicio
@Transactional
public class RedSocialService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;


    public void anadirPersona(Persona persona) {

        personaRepository.save(persona);

    }

    public void anadirPareja (Persona persona1, Persona persona2) {

        Pareja pareja = new Pareja(persona1, persona2);
        parejaRepository.save(pareja);
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
}
