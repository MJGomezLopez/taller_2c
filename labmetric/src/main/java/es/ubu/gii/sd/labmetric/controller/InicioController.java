package es.ubu.gii.sd.labmetric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Clase controlador para el modelo de usuarios
 */
@Controller
public class InicioController {

	@GetMapping({"/", "/inicio"})
	public String inicio() {
		return "inicio";
	}
	
}
