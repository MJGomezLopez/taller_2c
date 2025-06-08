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
	
	
	@GetMapping("/analistas/nuevo")
	public String mostrarFormularioNuevoAnalista(Model model) {
	    model.addAttribute("analista", new Analista());
	    return "nuevo_analista";
	}

	@PostMapping("/analistas/guardar")
	public String guardarAnalista(@ModelAttribute Analista analista) {
	    analistaRepo.save(analista);
	    return "redirect:/analistas";
	}
	
	@GetMapping("/analistas/eliminar/{id}")
	public String eliminarAnalista(@PathVariable Long id) {
	    analistaRepo.deleteById(id);
	    return "redirect:/analistas";
	}
	
    @GetMapping("/analistas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Analista analista = analistaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("analista", analista);
        return "editar_analista";
    }

    @PostMapping("/analistas/editar")
    public String actualizarAnalista(@ModelAttribute Analista analista) {
        System.out.println("ID recibido: " + analista.getId());
        analistaRepo.save(analista);
        return "redirect:/analistas";
    }

}
