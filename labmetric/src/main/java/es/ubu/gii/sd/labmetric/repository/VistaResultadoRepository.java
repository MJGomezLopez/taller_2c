package es.ubu.gii.sd.labmetric.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ubu.gii.sd.labmetric.model.VistaResultado;

/**
 * Repositorio para la vsita de resultados
 */

public interface VistaResultadoRepository extends JpaRepository<VistaResultado, Long> {
    Optional<VistaResultado> findByIdMuestra(Long idMuestra);
}
