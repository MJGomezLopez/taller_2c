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
	
	@GetMapping("/puntosDeMuestreo/editar/{id}")
	public String mostrarFormularioEditarPunto(@PathVariable Long id, Model model) {
	    PuntoMuestreo punto = pmRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
	    model.addAttribute("puntoMuestreo", punto);
	    model.addAttribute("rutas", rutaRepo.findAll());
	    return "puntos_muestreo_editar";
	}

	@PostMapping("/puntosDeMuestreo/editar/{id}")
	public String actualizarPuntoMuestreo(@PathVariable Long id, @ModelAttribute PuntoMuestreo puntoActualizado) {
	    PuntoMuestreo punto = pmRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

	    punto.setNombre(puntoActualizado.getNombre());
	    punto.setDescripcion(puntoActualizado.getDescripcion());
	    punto.setRuta(puntoActualizado.getRuta());

	    pmRepo.save(punto);
	    return "redirect:/puntosDeMuestreo";
	}
	
	@GetMapping("/puntosDeMuestreo/eliminar/{id}")
	public String eliminarPuntoMuestreo(@PathVariable Long id) {
	    PuntoMuestreo punto = pmRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
	    
	    pmRepo.delete(punto);
	    return "redirect:/puntosDeMuestreo";
	}

}
