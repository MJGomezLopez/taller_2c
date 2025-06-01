package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.MuestraRepository;

/**
 * Clase controlador para el modelo de muestras
 */
@RestController
public class MuestraController {

	@Autowired
	private MuestraRepository muestraRepo;

}
