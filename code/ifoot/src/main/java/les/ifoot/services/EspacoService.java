package les.ifoot.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Espaco;
import les.ifoot.repositories.EspacoRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service  
public class EspacoService {
    @Autowired
    private EspacoRepository repository;

    public Espaco findById(final Integer id) {
        try {
            Espaco obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Espaco.class.getName());
        }
    }

    public Collection<Espaco> findAll() {
        return repository.findAll();
    }

    public Espaco insert(final Espaco obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Espaço não foi(foram) preenchido(s)");
        }
    }

    public Espaco update(final Espaco obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Espaço não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir esse espaço por conta de uma de alguma associação!");
        }
    } // teste
}
