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
        try {
            Participacao obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Participacao.class.getName());
        }
    }

    public Collection<Participacao> findAll() {
        return repository.findAll();
    }

    public Participacao insert(Participacao obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Participacao não foi(foram) preenchido(s)");
        }
    }

    public Participacao update(Participacao obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Participacao não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Participacao vinculada a Itens de Empréstimos!");
        }
    }
}
