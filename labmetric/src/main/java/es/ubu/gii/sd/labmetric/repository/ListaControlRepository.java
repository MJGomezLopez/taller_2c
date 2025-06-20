package es.ubu.gii.sd.labmetric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.ListaControl;

/**
 * Interfaz que se usara como el repositorio para la clase ListaControl
 */
public interface ListaControlRepository extends JpaRepository<ListaControl, Long>  {

}
