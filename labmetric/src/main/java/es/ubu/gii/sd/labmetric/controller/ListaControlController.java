package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.ubu.gii.sd.labmetric.repository.ListaControlRepository;

/**
 * Clase controlador para el modelo de la lista de control
 */
@Controller
public class ListaControlController {

	@Autowired
	private ListaControlRepository listaRepo;
	
    @GetMapping("/listaControl")
    public String verListaControl(Model model) {
        model.addAttribute("registros", listaRepo.findAll());
        return "listaControl";
    }

}
