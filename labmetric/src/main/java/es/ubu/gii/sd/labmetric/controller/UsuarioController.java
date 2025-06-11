package es.ubu.gii.sd.labmetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import es.ubu.gii.sd.labmetric.model.Usuario;
import es.ubu.gii.sd.labmetric.repository.UsuarioRepository;

/**
 * Clase controlador para el modelo de usuarios
 */
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuRepo;
	
    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    // Procesar formulario de registro
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuRepo.save(usuario);
        return "redirect:/registro?exito"; // Redirección con indicador de éxito
    }
    
    // Mostrar el formulario de login
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }
    /*
    // Procesar el login
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombreUsuario,
                                @RequestParam String clave,
                                Model model) {
        Usuario usuario = usuRepo.findByNombreUsuarioAndClave(nombreUsuario, clave);

        if (usuario != null) {
            return "redirect:/principal";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
    */
	
}
