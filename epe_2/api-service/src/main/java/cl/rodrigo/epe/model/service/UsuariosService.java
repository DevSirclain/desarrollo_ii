package cl.rodrigo.epe.model.service;


import cl.rodrigo.epe.model.entity.UsuariosVO;
import cl.rodrigo.epe.model.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioDAO usuariosRepository;

    public List<UsuariosVO> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosVO> getUsuarioById(Long usuarioId) {
        return usuariosRepository.findById(usuarioId);
    }

    public UsuariosVO createUsuario(UsuariosVO usuario) {
        return usuariosRepository.save(usuario);
    }

    public UsuariosVO updateUsuario(UsuariosVO usuario) {
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuario(Long usuarioId) {
        usuariosRepository.deleteById(usuarioId);
    }
}
