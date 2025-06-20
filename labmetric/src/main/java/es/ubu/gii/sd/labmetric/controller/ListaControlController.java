package es.ubu.gii.sd.labmetric.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ubu.gii.sd.labmetric.model.ListaControl;
import es.ubu.gii.sd.labmetric.model.PuntoMuestreo;
import es.ubu.gii.sd.labmetric.model.Ruta;
import es.ubu.gii.sd.labmetric.repository.ListaControlRepository;
import es.ubu.gii.sd.labmetric.repository.PuntoMuestreoRepository;
import es.ubu.gii.sd.labmetric.repository.RutaRepository;
import es.ubu.gii.sd.labmetric.repository.TecnicoCampoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Clase controlador para el modelo de la lista de control
 */
@Controller
public class ListaControlController {

    @Autowired
    private ListaControlRepository listaRepo;

    @Autowired
    private TecnicoCampoRepository tecnicoRepo;

    @Autowired
    private RutaRepository rutaRepo;

    @Autowired
    private PuntoMuestreoRepository puntoRepo;
    
    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping("/listaControl")
    public String verListaControl(Model model) {
        model.addAttribute("registros", listaRepo.findAll());
        return "listaControl";
    }

    @GetMapping("/listaControl/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("registro", new ListaControl());
        model.addAttribute("tecnicos", tecnicoRepo.findAll());
        model.addAttribute("rutas", rutaRepo.findAll());
        model.addAttribute("puntos", List.of());
        return "lista_control_nuevo";
    }

    @PostMapping("/listaControl/nuevo")
    public String guardarRegistro(@ModelAttribute ListaControl registro) {
        listaRepo.save(registro);
        return "redirect:/listaControl";
    }

    @GetMapping("/listaControl/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        // Buscar el objeto ListaControl por su ID
        ListaControl registro = listaRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Control no encontrada"));

        // Obtener todos los técnicos, rutas y puntos de muestreo
        List<PuntoMuestreo> puntos = registro.getRuta().getPuntosMuestreo();

        model.addAttribute("registro", registro);
        model.addAttribute("tecnicos", tecnicoRepo.findAll());
        model.addAttribute("rutas", rutaRepo.findAll());
        model.addAttribute("puntos", puntos);
        
        return "lista_control_editar";
    }

    @PostMapping("/listaControl/editar/{id}")
    public String actualizarRegistro(@PathVariable Long id, @ModelAttribute ListaControl registro) {
        // Verifica que el registro existe
        ListaControl existingRegistro = listaRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de Control no encontrada"));

        // Actualiza el registro con los nuevos datos
        existingRegistro.setFecha(registro.getFecha());
        existingRegistro.setTecnico(registro.getTecnico());
        existingRegistro.setRuta(registro.getRuta());
        existingRegistro.setPunto(registro.getPunto());

        // Guarda el registro actualizado
        listaRepo.save(existingRegistro);

        // Redirige a la lista de control
        return "redirect:/listaControl";
    }

    @GetMapping("/api/puntosDeMuestreoPorRuta/{id}")
    @ResponseBody
    public List<PuntoMuestreo> obtenerPuntosPorRuta(@PathVariable Long id) {
        Ruta ruta = rutaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada"));

        List<PuntoMuestreo> puntos = ruta.getPuntosMuestreo();

        if (puntos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No hay puntos de muestreo para esta ruta");
        }

        // Evitar recursión infinita al serializar
        puntos.forEach(p -> {
            p.setRuta(null);
            p.setListaControles(null);
        });

        return puntos;
    }
}

