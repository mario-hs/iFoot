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
import les.ifoot.model.TransferenciaJogador;
import les.ifoot.repositories.TransferenciaJogadorRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class TransferirJogadorService {
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private TransferenciaJogadorRepository repository;

    public TransferenciaJogador findById(Integer id) {
        try {
            TransferenciaJogador obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + TransferenciaJogador.class.getName());
        }
    }

    public Collection<TransferenciaJogador> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TransferenciaJogador insert(TransferenciaJogador obj) {
        try {
            if (validaTransacao(obj) == true) {
                return repository.save(obj);
            }
            throw new BusinessRuleException(
                    "Transferência não pode ser efetuada");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaJogador não foi(foram) preenchido(s)");
        }
    }

    public TransferenciaJogador update(TransferenciaJogador obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da TransferenciaJogador não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma TransferenciaJogador vinculada a Itens de Empréstimos!");
        }
    }

    // FEITO POR VICENZO
    public boolean validaTransacao(TransferenciaJogador obj) {
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        String dataAtual[] = new String[1];
        dataAtual = timeStamp.split(" ");

        Integer id_jogador = obj.getJogador_remetente().getId();

        double valorDigitado = obj.getValor();
        double valorSql = repository.findByDataLimiteDiarioValor(dataAtual[0], id_jogador);

        double valorTotal = valorDigitado + valorSql;
        double valorTransferir = 50 - valorSql;

        if (valorSql == 50) {
            throw new BusinessRuleException(
                    "Você já atingiu o limite de dinheiro para transferir. Seu limite de transferência é de 50 reais");
        }

        if (valorTotal > 50) {
            throw new BusinessRuleException(
                    "Ao fazer esta transferencia você supera o limite diário. Você ainda pode transferir "
                            + valorTransferir + " reias hoje");
        }

        if (repository.findByDataLimiteDiarioQuantidade(dataAtual[0], id_jogador) == false) { // < 3 ou NULL
            throw new BusinessRuleException("Você já excedeu o limite de 3 transferências diarias!");
        }

        return true;
    }

}
