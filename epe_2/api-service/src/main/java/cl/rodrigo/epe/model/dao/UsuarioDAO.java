package cl.rodrigo.epe.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.rodrigo.epe.model.entity.UsuariosVO;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuariosVO, Long> {

}
