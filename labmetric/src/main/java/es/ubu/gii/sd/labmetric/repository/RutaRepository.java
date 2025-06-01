package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.Ruta;

/**
 * Interfaz que se usara como el repositorio para la clase Ruta
 */
public interface RutaRepository extends JpaRepository<Ruta, Long>  {

}
