package es.ubu.gii.sd.labmetric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Clase controlador para puntos comunes
 */
@Controller
public class InicioController {

	@GetMapping({"/", "/inicio"})
	public String inicio() {
		return "inicio";
	}
	
    // Método para acceder a la pantalla principal
    @GetMapping("/principal")
    public String principal() {
        return "principal"; // Dirige a principal.html
    }
	
}
