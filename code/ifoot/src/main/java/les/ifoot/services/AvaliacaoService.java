package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Avaliacao;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.services.exceptions.DataIntegrityException;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao findById(final Integer id) {
        try {
            Avaliacao obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new les.ifoot.services.exceptions.ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Avaliacao.class.getName());
        }
    }

    public Collection<Avaliacao> findAll() {
        return repository.findAll();
    }

    public Avaliacao insert(final Avaliacao obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Avaliacao não foi(foram) preenchido(s)");
        }
    }

    public Avaliacao update(final Avaliacao obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de Avaliacao não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir esta Avaliacao pois ele está cadastrado em algum outro campo");
        }
    }

    
}
