package api.servicios.epe3.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api.servicios.epe3.model.vo.EstudiantesVO;


@RepositoryRestResource(exported = false)
public interface EstudiantesDAO extends JpaRepository<EstudiantesVO, Long> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM EstudiantesVO e WHERE e.rut = :rut")
    Boolean existsByRut(@Param("rut") String rut);

    @Modifying
    @Transactional
    @Query("DELETE FROM EstudiantesVO e WHERE e.rut = :rut")
    void deleteByRut(@Param("rut") String rut);

    // @Query("SELECT e FROM EstudiantesVO e JOIN e.cursos c WHERE c.id = :cursoId")
    // List<EstudiantesVO> findEstudiantesByCursoId(@Param("cursoId") Long cursoId);
}