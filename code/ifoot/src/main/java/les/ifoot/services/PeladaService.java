package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Pelada;
import les.ifoot.repositories.PeladaRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class PeladaService {
    @Autowired
    private PeladaRepository repository;

    public Pelada findById(Integer id) {
        try {
            Pelada obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pelada.class.getName());
        }
    }

    public Collection<Pelada> findAll() {
        return repository.findAll();
    }

    public Pelada insert(Pelada obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Pelada não foi(foram) preenchido(s)");
        }
    }

    public Pelada update(Pelada obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Pelada não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma Pelada vinculada a Itens de Empréstimos!");
        }
    }
}
