package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.Muestra;

/**
 * Interfaz que se usara como el repositorio para la clase Muestra
 */
public interface MuestraRepository extends JpaRepository<Muestra, Long>  {

}
