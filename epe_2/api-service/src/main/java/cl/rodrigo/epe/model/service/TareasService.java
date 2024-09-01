package cl.rodrigo.epe.model.service;


import cl.rodrigo.epe.model.entity.TareasVO;
import cl.rodrigo.epe.model.dao.TareasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareasService {

    @Autowired
    private TareasDAO tareasRepository;

    public List<TareasVO> getAllTareas() {
        return tareasRepository.findAll();
    }

    public Optional<TareasVO> getTareaById(Long tareaId) {
        return tareasRepository.findById(tareaId);
    }

    public TareasVO createTarea(TareasVO tarea) {
        return tareasRepository.save(tarea);
    }

    public TareasVO updateTarea(TareasVO tarea) {
        return tareasRepository.save(tarea);
    }

    public void deleteTarea(Long tareaId) {
        tareasRepository.deleteById(tareaId);
    }
}
