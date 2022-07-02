package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Participacao;
import les.ifoot.repositories.ParticipacaoRepository;

@Service
public class ParticipacaoService {
    @Autowired
    private ParticipacaoRepository repository;

    public Participacao findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Participacao> findAll() {
        return repository.findAll();
    }

    public Participacao insert(Participacao obj) {
        return repository.save(obj);
    }

    public Participacao update(Participacao obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
