package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.CampoHorario;
import les.ifoot.repositories.CampoHorarioRepository;

@Service
public class CampoHorarioService {
    @Autowired
    private CampoHorarioRepository repository;

    public CampoHorario findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<CampoHorario> findAll() {
        return repository.findAll();
    }

    public CampoHorario insert(CampoHorario obj) {
        return repository.save(obj);
    }

    public CampoHorario update(CampoHorario obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
