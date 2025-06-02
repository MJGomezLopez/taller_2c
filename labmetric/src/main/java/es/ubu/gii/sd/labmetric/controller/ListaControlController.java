package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.ubu.gii.sd.labmetric.repository.ListaControlRepository;

/**
 * Clase controlador para el modelo de la lista de control
 */
@Controller
public class ListaControlController {

	@Autowired
	private ListaControlRepository listaRepo;

}
