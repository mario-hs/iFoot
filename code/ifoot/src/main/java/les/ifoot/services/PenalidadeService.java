package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Penalidade;
import les.ifoot.repositories.PenalidadeRepository;

@Service
public class PenalidadeService {
    @Autowired
    private PenalidadeRepository repository;

    public Penalidade findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Penalidade> findAll() {
        return repository.findAll();
    }

    public Penalidade insert(Penalidade obj) {
        return repository.save(obj);
    }

    public Penalidade update(Penalidade obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
