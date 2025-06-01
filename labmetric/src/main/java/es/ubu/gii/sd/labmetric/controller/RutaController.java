package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.RutaRepository;

/**
 * Clase controlador para el modelo de rutas
 */
@RestController
public class RutaController {

	@Autowired
	private RutaRepository rutaRepo;

}
