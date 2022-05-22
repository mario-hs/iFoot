package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Advertencia;
import les.ifoot.repositories.AdvertenciaRepository;

@Service
public class AdvertenciaService {
    @Autowired
    private AdvertenciaRepository repository;

    public Advertencia findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Advertencia> findAll() {
        return repository.findAll();
    }

    public Advertencia insert(Advertencia obj) {
        return repository.save(obj);
    }

    public Advertencia update(Advertencia obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
