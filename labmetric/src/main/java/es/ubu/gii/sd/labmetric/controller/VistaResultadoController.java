package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.ubu.gii.sd.labmetric.model.VistaResultado;
import es.ubu.gii.sd.labmetric.repository.VistaResultadoRepository;

import java.util.Optional;

@Controller
public class VistaResultadoController {

    @Autowired
    private VistaResultadoRepository vistaResultadoRepository;

    @GetMapping("/muestras/resultados/{id}")
    public String mostrarResultados(@PathVariable("id") Long id, Model model) {
        Optional<VistaResultado> resultado = vistaResultadoRepository.findByIdMuestra(id);
        if (resultado.isPresent()) {
            model.addAttribute("resultado", resultado.get());
            return "resultados_muestra";
        } else {
            return "error/404";
        }
    }
}
