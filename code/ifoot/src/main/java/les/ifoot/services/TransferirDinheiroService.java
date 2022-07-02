package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.repositories.TransferirDinheiroRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class TransferirDinheiroService {
    @Autowired
    private TransferirDinheiroRepository repository;

    public TransferirDinheiro findById(Integer id) {
        try {
            TransferirDinheiro obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + TransferirDinheiro.class.getName());
        }
    }

    public Collection<TransferirDinheiro> findAll() {
        return repository.findAll();
    }

    public TransferirDinheiro insert(TransferirDinheiro obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da TransferirDinheiro não foi(foram) preenchido(s)");
        }
    }

    public TransferirDinheiro update(TransferirDinheiro obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da TransferirDinheiro não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma TransferirDinheiro vinculada a Itens de Empréstimos!");
        }
    }

}

