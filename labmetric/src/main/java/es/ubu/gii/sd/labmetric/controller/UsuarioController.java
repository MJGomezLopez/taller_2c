package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.UsuarioRepository;

/**
 * Clase controlador para el modelo de usuarios
 */
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuRepo;
	
	@GetMapping()
	public String prueba() {
		return "CONECTADO";
	}
}
