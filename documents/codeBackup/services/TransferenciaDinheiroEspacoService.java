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
        return repository.findById(id).get();
    }

    public List<TransferenciaDinheiroEspaco> findAll() {
        return repository.findAll();
    }

    public TransferenciaDinheiroEspaco insert(TransferenciaDinheiroEspaco obj) {
        return repository.save(obj);
    }

    public TransferenciaDinheiroEspaco update(TransferenciaDinheiroEspaco obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}

