package es.ubu.gii.sd.labmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.Analista;
import es.ubu.gii.sd.labmetric.repository.AnalistaRepository;

/**
 * Clase controlador para el modelo de los analistas
 */
@Controller
public class AnalistaController {

	@Autowired
	private AnalistaRepository analistaRepo;
	
	@GetMapping("/analistas")
	public String listarAnalistas(Model model) {
	    List<Analista> analistas = analistaRepo.findAll();
	    model.addAttribute("analistas", analistas);
	    return "analistas";
	}

}
