package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Espaco;
import les.ifoot.repositories.EspacoRepository;

@Service
public class EspacoService {
    @Autowired
    private EspacoRepository repository;

    public Espaco findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Espaco> findAll() {
        return repository.findAll();
    }

    public Espaco insert(Espaco obj) {
        return repository.save(obj);
    }

    public Espaco update(Espaco obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
