package es.ubu.gii.sd.labmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.Muestra;
import es.ubu.gii.sd.labmetric.repository.AnalistaRepository;
import es.ubu.gii.sd.labmetric.repository.MuestraRepository;

/**
 * Clase controlador para el modelo de muestras
 */
@Controller
public class MuestraController {

	@Autowired
	private MuestraRepository muestraRepo;
	
	@Autowired
	private AnalistaRepository analistaRepo;
	
    @GetMapping("/muestras")
    public String listarMuestras(Model model) {
        List<Muestra> muestras = muestraRepo.findAll();
        model.addAttribute("muestras", muestras);
        return "muestras";
    }
    
    @GetMapping("/muestras/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Muestra muestra = muestraRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de muestra inválido: " + id));
        model.addAttribute("muestra", muestra);
        model.addAttribute("analistas", analistaRepo.findAll()); // Asegúrate de tener este repositorio
        return "editar_muestra";
    }

    @PostMapping("/muestras/editar/{id}")
    public String guardarEdicion(@PathVariable Long id, @ModelAttribute Muestra muestraActualizada) {
        Muestra muestraExistente = muestraRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de muestra inválido: " + id));

        // Solo actualizamos los campos editables
        muestraExistente.setPh(muestraActualizada.getPh());
        muestraExistente.setDbo(muestraActualizada.getDbo());
        muestraExistente.setDqo(muestraActualizada.getDqo());
        muestraExistente.setSt(muestraActualizada.getSt());
        muestraExistente.setCe(muestraActualizada.getCe());
        muestraExistente.setNo3(muestraActualizada.getNo3());
        muestraExistente.setNh4(muestraActualizada.getNh4());
        muestraExistente.setPo4(muestraActualizada.getPo4());
        muestraExistente.setAlca(muestraActualizada.getAlca());
        muestraExistente.setCl(muestraActualizada.getCl());
        muestraExistente.setFe(muestraActualizada.getFe());
        muestraExistente.setSo4(muestraActualizada.getSo4());
        muestraExistente.setOd(muestraActualizada.getOd());
        muestraExistente.setCot(muestraActualizada.getCot());
        muestraExistente.setAnalista(muestraActualizada.getAnalista());

        muestraRepo.save(muestraExistente);
        return "redirect:/muestras";
    }


}
