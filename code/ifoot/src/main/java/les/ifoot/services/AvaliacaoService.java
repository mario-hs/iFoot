package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Avaliacao;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
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
        try {
            if (handleAvaliacao(obj) == true) {
                return repository.save(obj);
            }
            throw new BusinessRuleException("Transferência não pode ser efetuada");
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

    public boolean handleAvaliacao(Avaliacao obj) {

        Integer id_jogador = obj.getJogador_avaliador().getId();
        boolean valorSql = repository.findByAdvertenciaJogador(id_jogador);
        System.out.println(valorSql);

        // if (valorSql == 50) {
        // throw new BusinessRuleException("Você ja atingiu o limite de dinheiro para
        // transferir");
        // }

        // if (valorTotal > 50) {
        // throw new BusinessRuleException(
        // "Ao fazer esta transferencia voce supera o limtie diario. Você ainda pode
        // transferir "
        // + valorTransferir + " reias hoje");
        // }

        // if (repository.findByTransferenciaJogador(dataAtual[0], idJogador) == false)
        // { // < 3 ou NULL
        // throw new BusinessRuleException("Jogador já excedeu o limite de
        // transferências no dia de hoje");
        // }

        return true;
    }

}
