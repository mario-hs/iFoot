package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Posicao;
import les.ifoot.repositories.PosicaoRepository;

@Service
public class PosicaoService {
    @Autowired
    private PosicaoRepository repository;

    public Posicao findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Posicao> findAll() {
        return repository.findAll();
    }

    public Posicao insert(Posicao obj) {
        return repository.save(obj);
    }

    public Posicao update(Posicao obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
