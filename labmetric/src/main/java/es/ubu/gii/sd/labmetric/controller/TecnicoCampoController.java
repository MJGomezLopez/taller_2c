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
	private TecnicoCampoRepository tcRepo;
	
	@GetMapping("/tecnicos")
	public String listarTecnicos(Model model) {
	    List<TecnicoCampo> tecnicos = tcRepo.findAll();
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
	    tcRepo.save(tecnico);
	    return "redirect:/tecnicos";
	}
	
	@GetMapping("/tecnicos/eliminar/{id}")
	public String eliminarTecnico(@PathVariable Long id) {
	    tcRepo.deleteById(id);
	    return "redirect:/tecnicos";
	}
	
    @GetMapping("/tecnicos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        TecnicoCampo tecnico = tcRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("tecnico", tecnico);
        return "editar_tecnico";
    }

    @PostMapping("/tecnicos/editar")
    public String actualizarTecnico(@ModelAttribute TecnicoCampo tecnico) {
        System.out.println("ID recibido: " + tecnico.getId());
        tcRepo.save(tecnico);
        return "redirect:/tecnicos";
    }

}
