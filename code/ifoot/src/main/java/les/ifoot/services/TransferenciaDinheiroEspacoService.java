package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.TransferenciaDinheiroEspaco;
import les.ifoot.repositories.TransferenciaDinheiroEspacoRepository;

@Service
public class TransferenciaDinheiroEspacoService {

    @Autowired
    private TransferenciaDinheiroEspacoRepository repository;

    public TransferenciaDinheiroEspaco findById(Integer id) {
        try {
            TransferenciaDinheiroEspaco obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + TransferenciaDinheiroEspaco.class.getName());
        }
    }

    public Collection<TransferenciaDinheiroEspaco> findAll() {
        return repository.findAll();
    }

    public TransferenciaDinheiroEspaco insert(TransferenciaDinheiroEspaco obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaDinheiroEspaco não foi(foram) preenchido(s)");
        }
    }

    public TransferenciaDinheiroEspaco update(TransferenciaDinheiroEspaco obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaDinheiroEspaco não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma TransferenciaDinheiroEspaco vinculada a Itens de Empréstimos!");
        }
    }

}

