package les.ifoot.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.NoSuchElementException;
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
    public TransferirDinheiro insert(TransferirDinheiro obj) {

        Integer idJogador = obj.getJogadorRemetente().getId();

        try {
            if (validaTransacao(idJogador, obj) == true) {
                return repository.save(obj);
            }
            throw new BusinessRuleException(
                    "Transferência não pode ser efetuada");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferirDinheiro não foi(foram) preenchido(s)");
        }
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

    public boolean validaTransacao(Integer idJogador, TransferirDinheiro obj) {
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        String dataAtual[] = new String[1];
        dataAtual = timeStamp.split(" ");

        double valorDigitado = obj.getValor();
        double valorSql = repository.findByTransferenciaValorJogador(dataAtual[0], idJogador);
        // System.err.println(valorDigitado);

        double valorTotal = valorDigitado + valorSql;
        double valorTransferir = 50 - valorSql;
        // System.err.println(aux[0]);
        // System.out.println(repository.findByTransferenciaJogador(aux[0], idJogador));
        // System.out.println(repository.findByTransferenciaValorJogador(aux[0],
        // idJogador));

        if (valorSql == 50) {
            throw new BusinessRuleException("Você ja atingiu o limite de dinheiro para transferir");
        }

        if (valorTotal > 50) {
            throw new BusinessRuleException(
                    "Ao fazer esta transferencia voce supera o limtie diario. Você ainda pode transferir "
                            + valorTransferir + " reias hoje");
        }

        if (repository.findByTransferenciaJogador(dataAtual[0], idJogador) == false) { // < 3 ou NULL
            throw new BusinessRuleException("Jogador já excedeu o limite de transferências no dia de hoje");
        }

        return true;
    }

}
