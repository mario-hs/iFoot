package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.TransferenciaEspaco;
import les.ifoot.repositories.TransferenciaEspacoRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class TransferenciaEspacoService {

    @Autowired
    private TransferenciaEspacoRepository repository;

    public TransferenciaEspaco findById(Integer id) {
        try {
            TransferenciaEspaco obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + TransferenciaEspaco.class.getName());
        }
    }

    public Collection<TransferenciaEspaco> findAll() {
        return repository.findAll();
    }

    public TransferenciaEspaco insert(TransferenciaEspaco obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaEspaco não foi(foram) preenchido(s)");
        }
    }

    public TransferenciaEspaco update(TransferenciaEspaco obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaEspaco não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma TransferenciaEspaco vinculada a Itens de Empréstimos!");
        }
    }

}
