package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.PuntoMuestreoRepository;

/**
 * Clase controlador para el modelo de punto de muestreos
 */
@RestController
public class PuntoMuestreoController {
	
	@Autowired
	private PuntoMuestreoRepository pmRepo;
	
}
