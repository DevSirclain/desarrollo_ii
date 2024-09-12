package api.servicios.epe3.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api.servicios.epe3.model.vo.CursosVO;



@RepositoryRestResource(exported = false)
public interface CursosDAO extends JpaRepository<CursosVO, Long> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM CursosVO e WHERE e.codigo = :codigo")
    Boolean existsByCodigo(@Param("codigo") String codigo);

    @Modifying
    @Transactional
    @Query("DELETE FROM CursosVO e WHERE e.codigo = :codigo")
    void deleteByCodigo(@Param("codigo") String codigo);

    // @Query("SELECT e FROM EstudiantesVO e JOIN e.cursos c WHERE c.id = :cursoId")
    // List<EstudiantesVO> findEstudiantesByCursoId(@Param("cursoId") Long cursoId);
}