package api.servicios.epe3.controller;

import org.springframework.web.bind.annotation.*;


import api.servicios.epe3.model.dao.ProfesoresDAO;
import api.servicios.epe3.model.vo.ProfesoresVO;
import api.servicios.epe3.util.service.AsignaturasService;
import api.servicios.epe3.util.service.ProfesoresService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profesores")
public class ProfesoresController {

    private final ProfesoresService profesoresService;
    private final ProfesoresDAO profesoresDAO;
    
    public ProfesoresController(ProfesoresService profesoresService,ProfesoresDAO profesoresDAO) {
        this.profesoresService = profesoresService;
		this.profesoresDAO = profesoresDAO;
    }

    @PostMapping("/crear")
    public void crearEstudiante(@RequestBody ProfesoresVO asignatura) {
    	profesoresDAO.save(asignatura);
    }

    @GetMapping("/{id}")
    public Optional<ProfesoresVO> obtenerEstudiantePorId(@PathVariable Long id) {
        return profesoresDAO.findById(id);
    }

    @GetMapping("/todos")
    public List<ProfesoresVO> obtenerTodosLosEstudiantes() {
        return profesoresDAO.findAll();
    }

    @PutMapping("/actualizar")
    public void actualizarEstudiante(@RequestBody ProfesoresVO asignatura) {
    	profesoresDAO.save(asignatura);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
    	profesoresDAO.deleteById(id);
    }
}
