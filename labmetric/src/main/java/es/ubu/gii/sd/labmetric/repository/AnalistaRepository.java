package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.Analista;

/**
 * Interfaz que se usara como el repositorio para la clase Analista
 */
public interface AnalistaRepository extends JpaRepository<Analista, Long> {

}
