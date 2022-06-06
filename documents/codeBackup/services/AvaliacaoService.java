package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Avaliacao;
import les.ifoot.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Avaliacao> findAll() {
        return repository.findAll();
    }

    public Avaliacao insert(Avaliacao obj) {
        return repository.save(obj);
    }

    public Avaliacao update(Avaliacao obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
