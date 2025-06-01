package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.TecnicoCampoRepository;

/**
 * Clase controlador para el modelo de los tecnicos de campos
 */
@RestController
public class TecnicoCampoController {

	@Autowired
	private TecnicoCampoRepository rutaRepo;

}
