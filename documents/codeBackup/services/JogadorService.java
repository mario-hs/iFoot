package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Jogador;
import les.ifoot.repositories.JogadorRepository;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository repository;

    public Jogador findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Jogador> findAll() {
        return repository.findAll();
    }

    public Jogador insert(Jogador obj) {
        return repository.save(obj);
    }

    public Jogador update(Jogador obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
