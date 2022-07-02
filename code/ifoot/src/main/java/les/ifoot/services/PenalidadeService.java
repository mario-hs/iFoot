package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.Penalidade;
import les.ifoot.repositories.PenalidadeRepository;

@Service
public class PenalidadeService {
    @Autowired
    private PenalidadeService repository;

    public Penalidade findById(Integer id) {
        try {
            Penalidade obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Penalidade.class.getName());
        }
    }

    public Collection<Penalidade> findAll() {
        return repository.findAll();
    }

    public Penalidade insert(Penalidade obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Penalidade não foi(foram) preenchido(s)");
        }
    }

    public Penalidade update(Penalidade obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Penalidade não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma Penalidade vinculada a Itens de Empréstimos!");
        }
    }
}
