package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.AnalistaRepository;

/**
 * Clase controlador para el modelo de los analistas
 */
@RestController
public class AnalistaController {

	@Autowired
	private AnalistaRepository analistaRepo;

}
