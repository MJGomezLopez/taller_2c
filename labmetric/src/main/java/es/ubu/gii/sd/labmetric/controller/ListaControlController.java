package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.ListaControlRepository;

/**
 * Clase controlador para el modelo de la lista de control
 */
@RestController
public class ListaControlController {

	@Autowired
	private ListaControlRepository listaRepo;

}
