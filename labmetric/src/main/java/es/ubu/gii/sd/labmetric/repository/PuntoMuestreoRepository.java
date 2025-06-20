package es.ubu.gii.sd.labmetric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ubu.gii.sd.labmetric.model.PuntoMuestreo;

/**
 * Interfaz que se usara como el repositorio para la clase PuntoMuestreo
 */
public interface PuntoMuestreoRepository extends JpaRepository<PuntoMuestreo, Long> {

	List<PuntoMuestreo> findByRutaId(Long rutaId);

}
