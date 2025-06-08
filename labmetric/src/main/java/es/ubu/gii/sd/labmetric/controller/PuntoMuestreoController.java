package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.repository.PuntoMuestreoRepository;

/**
 * Clase controlador para el modelo de punto de muestreos
 */
@Controller
public class PuntoMuestreoController {
	
	@Autowired
	private PuntoMuestreoRepository pmRepo;
	
	@GetMapping("/puntosDeMuestreo")
	public String listarPuntosDeMuestreo(Model model) {
	    model.addAttribute("puntos", pmRepo.findAll());
	    return "puntos_muestreo";
	}

	
}
