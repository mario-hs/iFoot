package les.ifoot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.repositories.TransferirDinheiroRepository;

@Service
public class TransferirDinheiroService {
    @Autowired
    private TransferirDinheiroRepository repository;

    public TransferirDinheiro findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<TransferirDinheiro> findAll() {
        return repository.findAll();
    }

    public TransferirDinheiro insert(TransferirDinheiro obj) {
        return repository.save(obj);
    }

    public TransferirDinheiro update(TransferirDinheiro obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}

