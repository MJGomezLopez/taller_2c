package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.ubu.gii.sd.labmetric.repository.AnalistaRepository;

/**
 * Clase controlador para el modelo de los analistas
 */
@Controller
public class AnalistaController {

	@Autowired
	private AnalistaRepository analistaRepo;

}
