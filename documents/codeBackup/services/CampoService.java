package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Campo;
import les.ifoot.repositories.CampoRepository;

@Service
public class CampoService {
    @Autowired
    private CampoRepository repository;

    public Campo findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Campo> findAll() {
        return repository.findAll();
    }

    public Campo insert(Campo obj) {
        return repository.save(obj);
    }

    public Campo update(Campo obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
