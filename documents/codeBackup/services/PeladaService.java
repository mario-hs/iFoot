package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Pelada;
import les.ifoot.repositories.PeladaRepository;

@Service
public class PeladaService {
    @Autowired
    private PeladaRepository repository;

    public Pelada findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Pelada> findAll() {
        return repository.findAll();
    }

    public Pelada insert(Pelada obj) {
        return repository.save(obj);
    }

    public Pelada update(Pelada obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
