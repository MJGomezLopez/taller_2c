package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.PuntoMuestreo;
import es.ubu.gii.sd.labmetric.repository.PuntoMuestreoRepository;
import es.ubu.gii.sd.labmetric.repository.RutaRepository;

/**
 * Clase controlador para el modelo de punto de muestreos
 */
@Controller
public class PuntoMuestreoController {
	
	@Autowired
	private PuntoMuestreoRepository pmRepo;
	
	@Autowired
	private RutaRepository rutaRepo;
	
	@GetMapping("/puntosDeMuestreo")
	public String listarPuntosDeMuestreo(Model model) {
	    model.addAttribute("puntos", pmRepo.findAll());
	    return "puntos_muestreo";
	}
	
	@GetMapping("/puntosDeMuestreo/nuevo")
	public String mostrarFormularioNuevoPunto(Model model) {
	    model.addAttribute("puntoMuestreo", new PuntoMuestreo());
	    model.addAttribute("rutas", rutaRepo.findAll());
	    return "puntos_muestreo_nuevo";
	}

	@PostMapping("/puntosDeMuestreo/nuevo")
	public String guardarPuntoMuestreo(@ModelAttribute PuntoMuestreo puntoMuestreo) {
	    pmRepo.save(puntoMuestreo);
	    return "redirect:/puntosDeMuestreo";
	}

}
