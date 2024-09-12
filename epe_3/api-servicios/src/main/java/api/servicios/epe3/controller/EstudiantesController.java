package api.servicios.epe3.controller;

import org.springframework.web.bind.annotation.*;

import api.servicios.epe3.model.vo.EstudiantesVO;
import api.servicios.epe3.util.service.EstudiantesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estudiantes")
@CrossOrigin(origins = "http://localhost")
public class EstudiantesController {

    private final EstudiantesService estudianteService;

    public EstudiantesController(EstudiantesService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping("/crear")
    public void crearEstudiante(@RequestBody EstudiantesVO estudiante) {
        estudianteService.crearEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    public Optional<EstudiantesVO> obtenerEstudiantePorId(@PathVariable Long id) {
        return estudianteService.obtenerEstudiantePorId(id);
    }

    @GetMapping("/todos")
    public List<EstudiantesVO> obtenerTodosLosEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }

    @PutMapping("/actualizar")
    public void actualizarEstudiante(@RequestBody EstudiantesVO estudiante) {
        estudianteService.actualizarEstudiante(estudiante);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
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
