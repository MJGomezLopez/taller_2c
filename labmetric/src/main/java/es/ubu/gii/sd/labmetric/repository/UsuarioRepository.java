package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ubu.gii.sd.labmetric.model.Usuario;

/**
 * Interfaz que se usara como el repositorio para la clase Usuario
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
