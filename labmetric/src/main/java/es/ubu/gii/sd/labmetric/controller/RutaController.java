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
        return "rutas";
    }
    
    @GetMapping("/rutas/nueva")
    public String mostrarFormularioNuevaRuta(Model model) {
        model.addAttribute("ruta", new Ruta());
        return "rutas_nueva";
    }

    @PostMapping("/rutas/nueva")
    public String crearRuta(@ModelAttribute("ruta") Ruta ruta) {
        rutaRepo.save(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/rutas/editar/{id}")
    public String mostrarFormularioEditarRuta(@PathVariable("id") Long id, Model model) {
        Ruta ruta = rutaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de ruta inválido: " + id));
        model.addAttribute("ruta", ruta);
        return "rutas_editar";
    }

    @PostMapping("/rutas/editar")
    public String actualizarRuta(@ModelAttribute("ruta") Ruta ruta) {
        rutaRepo.save(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/rutas/eliminar/{id}")
    public String eliminarRuta(@PathVariable("id") Long id) {
        rutaRepo.deleteById(id);
        return "redirect:/rutas";
    }
    
    @GetMapping("/ruta_puntos")
    public String listarPuntosDeRuta(@RequestParam("rutaId") Long rutaId, Model model) {
        Ruta ruta = rutaRepo.findById(rutaId)
            .orElseThrow(() -> new IllegalArgumentException("ID de ruta inválido: " + rutaId));
        model.addAttribute("ruta", ruta);
        return "ruta_puntos";
    }

}
