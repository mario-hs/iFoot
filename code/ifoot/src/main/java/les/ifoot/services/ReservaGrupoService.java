package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.ReservaGrupo;
import les.ifoot.repositories.ReservaGrupoRepository;

@Service
public class ReservaGrupoService {
    @Autowired
    private ReservaGrupoRepository repository;

    public ReservaGrupo findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<ReservaGrupo> findAll() {
        return repository.findAll();
    }

    public ReservaGrupo insert(ReservaGrupo obj) {
        return repository.save(obj);
    }

    public ReservaGrupo update(ReservaGrupo obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
