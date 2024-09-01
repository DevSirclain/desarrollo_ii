package cl.rodrigo.epe.controller;

import cl.rodrigo.epe.model.entity.TareasVO;
import cl.rodrigo.epe.model.service.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {

    @Autowired
    private TareasService tareasService;

    @GetMapping
    public ResponseEntity<List<TareasVO>> getAllTareas() {
        List<TareasVO> tareas = tareasService.getAllTareas();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareasVO> getTareaById(@PathVariable("id") Long tareaId) {
        Optional<TareasVO> tarea = tareasService.getTareaById(tareaId);
        return tarea.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TareasVO> createTarea(@RequestBody TareasVO tarea) {
        TareasVO nuevaTarea = tareasService.createTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareasVO> updateTarea(@PathVariable("id") Long tareaId, @RequestBody TareasVO tarea) {
        if (!tareasService.getTareaById(tareaId).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tarea.setTareaId(tareaId);
        TareasVO tareaActualizada = tareasService.updateTarea(tarea);
        return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable("id") Long tareaId) {
        if (!tareasService.getTareaById(tareaId).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tareasService.deleteTarea(tareaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
