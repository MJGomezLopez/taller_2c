package es.ubu.gii.sd.labmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.model.TecnicoCampo;
import es.ubu.gii.sd.labmetric.repository.TecnicoCampoRepository;

/**
 * Clase controlador para el modelo de los tecnicos de campos
 */
@Controller
public class TecnicoCampoController {

	@Autowired
	private TecnicoCampoRepository rutaRepo;
	
	@GetMapping("/tecnicos")
	public String listarTecnicos(Model model) {
	    List<TecnicoCampo> tecnicos = rutaRepo.findAll();
	    model.addAttribute("tecnicos", tecnicos);
	    return "tecnicos";
	}
	
	@GetMapping("/tecnicos/nuevo")
	public String mostrarFormularioNuevoTecnico(Model model) {
	    model.addAttribute("tecnico", new TecnicoCampo());
	    return "nuevo_tecnico";
	}

	@PostMapping("/tecnicos/guardar")
	public String guardarTecnico(@ModelAttribute TecnicoCampo tecnico) {
	    rutaRepo.save(tecnico);
	    return "redirect:/tecnicos";
	}
	
	@GetMapping("/tecnicos/eliminar/{id}")
	public String eliminarTecnico(@PathVariable Long id) {
	    rutaRepo.deleteById(id);
	    return "redirect:/tecnicos";
	}


}
