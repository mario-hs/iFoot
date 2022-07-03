package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.repositories.TransferirDinheiroRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class TransferirDinheiroService {
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private TransferirDinheiroRepository repository;

    public TransferirDinheiro findById(Integer id) {
        try {
            TransferirDinheiro obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + TransferirDinheiro.class.getName());
        }
    }

    public Collection<TransferirDinheiro> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TransferirDinheiro insert(TransferirDinheiro obj) throws ParseException {
        try {
            if (handleValorLimite(obj)) {
                obj.setId(null);
                return repository.save(obj);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferirDinheiro não foi(foram) preenchido(s)");
        }
        return null;
    }

    public TransferirDinheiro update(TransferirDinheiro obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferirDinheiro não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma TransferirDinheiro vinculada a Itens de Empréstimos!");
        }
    }

    public boolean handleValorLimite(TransferirDinheiro obj) throws ParseException {
        // Float qtdValor = repository.findByDataTransferencia(date.parse("24/06/2022"),
        // 2);
        TransferirDinheiro qtdValor = repository.findByDataTransferencia(date.parse("24/06/2022"), 2);
        if (qtdValor != null) {
            throw new BusinessRuleException("Jogador excede o valor diário de transferência!");
        }

        return true;
    }

    public TransferirDinheiro findByDataTransferencia(Date data, Integer id_jogador) {
        return repository.findByDataTransferencia(data, id_jogador);
    }

}
