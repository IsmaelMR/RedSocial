package com.example;

import com.example.domain.Persona;
import com.example.service.RedSocialService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // MAIN
public class DemoPersonaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(DemoPersonaApplication.class, args);

		//PersonaService personaService = context.getBean(PersonaService.class);

		//personaService.testPersonas();

		RedSocialService redSocialService = context.getBean(RedSocialService.class);
		//redSocialService.testNetwork();

		testRedSocial(redSocialService);

	}


	private static void testRedSocial(RedSocialService redSocialService) {
		Persona persona = new Persona();
		persona.setNombre("Ivan");
		persona.setApellido("Merino");
		persona.setEdad(23);
		//personaRepository.save(persona); // No podremos salvar la persona directamente en el repositorio debido al Principio de Encapsulacion (personaRepository es "private")
		redSocialService.anadirPersona(persona); // En su lugar, invocaremos al metodo correspondiente para interactuar con la BBDD y, en este caso, guardar a la persona en cuestion

		Persona persona2 = new Persona();
		persona2.setNombre("Dimple");
		persona2.setApellido("Perla");
		persona2.setEdad(25);
		redSocialService.anadirPersona(persona2);

		Persona persona3 = new Persona();
		persona3.setNombre("Ismael");
		persona3.setApellido("Rivera");
		persona3.setEdad(29);
		redSocialService.anadirPersona(persona3);

		Persona persona4 = new Persona();
		persona4.setNombre("Judith");
		persona4.setApellido("Sala");
		persona4.setEdad(24);
		redSocialService.anadirPersona(persona4);

		// Creamos otra persona para la prueba de parejas
		Persona novia = new Persona();
		novia.setNombre("novia");
		novia.setApellido("apellido");
		novia.setEdad(22);
		redSocialService.anadirPersona(novia);

		// Añadimos parejas
		redSocialService.anadirPareja(persona, novia);

		// Añadimos amistades
		redSocialService.anadirAmistad(persona, persona2);
		redSocialService.anadirAmistad(persona, persona3);

		System.out.println("La pareja de Ivan es: " + redSocialService.obtenerPareja(persona));
		System.out.println("Las amistades de Ivan son: " + redSocialService.obtenerAmistades(persona));
	}
}
