package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.ubu.gii.sd.labmetric.repository.RutaRepository;

/**
 * Clase controlador para el modelo de rutas
 */
@Controller
public class RutaController {

	@Autowired
	private RutaRepository rutaRepo;

}
