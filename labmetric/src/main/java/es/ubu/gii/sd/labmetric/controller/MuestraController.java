package es.ubu.gii.sd.labmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.Muestra;
import es.ubu.gii.sd.labmetric.repository.MuestraRepository;

/**
 * Clase controlador para el modelo de muestras
 */
@Controller
public class MuestraController {

	@Autowired
	private MuestraRepository muestraRepo;
	
    @GetMapping("/muestras")
    public String listarMuestras(Model model) {
        List<Muestra> muestras = muestraRepo.findAll();
        model.addAttribute("muestras", muestras);
        return "muestras";
    }

}
