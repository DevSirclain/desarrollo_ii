package api.servicios.epe3.controller;

import org.springframework.web.bind.annotation.*;

import api.servicios.epe3.model.dao.CursosDAO;
import api.servicios.epe3.model.vo.CursosVO;
import api.servicios.epe3.util.service.CursosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursosController {

    private final CursosService cursoService;
    private final CursosDAO cursosdao;

    public CursosController(CursosService cursoService, CursosDAO cursosdao) {
        this.cursoService = cursoService;
		this.cursosdao = cursosdao;
    }

    @PostMapping("/crear")
    public void crearEstudiante(@RequestBody CursosVO curso) {
    	cursosdao.save(curso);
    }

    @GetMapping("/{id}")
    public Optional<CursosVO> obtenerEstudiantePorId(@PathVariable Long id) {
        return cursosdao.findById(id);
    }

    @GetMapping("/todos")
    public List<CursosVO> obtenerTodosLosEstudiantes() {
        return cursosdao.findAll();
    }

    @PutMapping("/actualizar")
    public void actualizarEstudiante(@RequestBody CursosVO estudiante) {
    	cursosdao.save(estudiante);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
    	cursosdao.deleteById(id);
    }

    // Operaciones masivas
    // @PutMapping("/actualizar-edad/{cursoId}")
    // public void actualizarEdadEstudiantesEnCurso(@PathVariable Long cursoId, @RequestParam int nuevaEdad) {
    //    cursoService.actualizarEdadEstudiantesEnCurso(cursoId, nuevaEdad);
    // }

    // @DeleteMapping("/eliminar-sin-cursos")
    // public void eliminarEstudiantesSinCursos() {
    //     cursoService.eliminarEstudiantesSinCursos();
    // }
}
