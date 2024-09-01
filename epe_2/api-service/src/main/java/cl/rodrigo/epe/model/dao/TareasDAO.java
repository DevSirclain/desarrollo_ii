package cl.rodrigo.epe.model.dao;

import cl.rodrigo.epe.model.entity.TareasVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasDAO extends JpaRepository<TareasVO, Long> {
    // Métodos adicionales personalizados si es necesario
}
