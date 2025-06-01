package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.TecnicoCampo;

/**
 * Interfaz que se usara como el repositorio para la clase TecnicoCampo
 */
public interface TecnicoCampoRepository extends JpaRepository<TecnicoCampo, Long> {

}
