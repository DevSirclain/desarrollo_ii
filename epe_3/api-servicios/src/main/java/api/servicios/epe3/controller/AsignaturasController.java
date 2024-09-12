package api.servicios.epe3.controller;

import org.springframework.web.bind.annotation.*;

import api.servicios.epe3.model.dao.AsignaturasDAO;
import api.servicios.epe3.model.vo.AsignaturasVO;
import api.servicios.epe3.util.service.AsignaturasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/asignaturas")
public class AsignaturasController {

    private final AsignaturasService asignaturasService;
    private final AsignaturasDAO asignaturasDAO;
    
    public AsignaturasController(AsignaturasService asignaturasService, AsignaturasDAO asignaturasDAO) {
        this.asignaturasService = asignaturasService;
		this.asignaturasDAO = asignaturasDAO;
    }

    @PostMapping("/crear")
    public void crearEstudiante(@RequestBody AsignaturasVO asignatura) {
    	asignaturasDAO.save(asignatura);
    }

    @GetMapping("/{id}")
    public Optional<AsignaturasVO> obtenerEstudiantePorId(@PathVariable Long id) {
        return asignaturasDAO.findById(id);
    }

    @GetMapping("/todos")
    public List<AsignaturasVO> obtenerTodosLosEstudiantes() {
        return asignaturasDAO.findAll();
    }

    @PutMapping("/actualizar")
    public void actualizarEstudiante(@RequestBody AsignaturasVO asignatura) {
    	asignaturasDAO.save(asignatura);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
    	asignaturasDAO.deleteById(id);
    }

    // Operaciones masivas
    // @PutMapping("/actualizar-edad/{cursoId}")
    // public void actualizarEdadEstudiantesEnCurso(@PathVariable Long cursoId, @RequestParam int nuevaEdad) {
    //    estudianteService.actualizarEdadEstudiantesEnCurso(cursoId, nuevaEdad);
    // }

    // @DeleteMapping("/eliminar-sin-cursos")
    // public void eliminarEstudiantesSinCursos() {
    //     estudianteService.eliminarEstudiantesSinCursos();
    // }
}
