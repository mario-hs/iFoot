package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Horario;
import les.ifoot.repositories.HorarioRepository;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository repository;

    public Horario findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Horario> findAll() {
        return repository.findAll();
    }

    public Horario insert(Horario obj) {
        return repository.save(obj);
    }

    public Horario update(Horario obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
