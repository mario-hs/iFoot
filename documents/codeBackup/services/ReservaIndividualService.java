package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.ReservaIndividual;
import les.ifoot.repositories.ReservaIndividualRepository;

@Service
public class ReservaIndividualService {
    @Autowired
    private ReservaIndividualRepository repository;
    
    public ReservaIndividual findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<ReservaIndividual> findAll() {
        return repository.findAll();
    }

    public ReservaIndividual insert(ReservaIndividual obj) {
        return repository.save(obj);
    }

    public ReservaIndividual update(ReservaIndividual obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
