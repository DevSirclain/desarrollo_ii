package api.servicios.epe3.util.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.servicios.epe3.model.dao.EstudiantesDAO;
import api.servicios.epe3.model.vo.EstudiantesVO;
@Service
public class EstudiantesService {

    private EstudiantesDAO estudianteDAO;

    public EstudiantesService(EstudiantesDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public void crearEstudiante(EstudiantesVO estudiante) {
        estudianteDAO.save(estudiante);
    }

    public Optional<EstudiantesVO> obtenerEstudiantePorId(Long id) {
        return estudianteDAO.findById(id);
    }

    public List<EstudiantesVO> obtenerTodosLosEstudiantes() {
        return estudianteDAO.findAll();
    }

    public void actualizarEstudiante(EstudiantesVO estudiante) {
        estudianteDAO.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        estudianteDAO.deleteById(id);
    }

    public List<EstudiantesVO> obtenerEstudiantesPorCurso(Long cursoId) {
        // return estudianteDAO.findEstudiantesByCursoId(cursoId);
    	return estudianteDAO.findAll();
    }

}
