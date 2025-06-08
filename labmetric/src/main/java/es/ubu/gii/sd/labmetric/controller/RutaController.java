package es.ubu.gii.sd.labmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.Ruta;
import es.ubu.gii.sd.labmetric.repository.RutaRepository;

/**
 * Clase controlador para el modelo de rutas
 */
@Controller
public class RutaController {

	@Autowired
	private RutaRepository rutaRepo;
	
    @GetMapping("/rutas")
    public String listarRutas(Model model) {
        List<Ruta> rutas = rutaRepo.findAll();
        model.addAttribute("rutas", rutas);
        return "rutas"; // corresponde a rutas.html
    }

}
