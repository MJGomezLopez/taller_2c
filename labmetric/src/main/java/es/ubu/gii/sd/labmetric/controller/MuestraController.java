package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.ubu.gii.sd.labmetric.repository.MuestraRepository;

/**
 * Clase controlador para el modelo de muestras
 */
@Controller
public class MuestraController {

	@Autowired
	private MuestraRepository muestraRepo;

}
