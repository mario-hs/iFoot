package les.ifoot.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.ifoot.model.Avaliacao;
import les.ifoot.model.Jogador;
import les.ifoot.model.ReservaIndividual;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.repositories.JogadorRepository;
import les.ifoot.repositories.ReservaIndividualRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository repository;
    @Autowired
    private ReservaIndividualRepository reservaIndividualRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Jogador findById(Integer id) {
        try {
            Jogador obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Jogador.class.getName());
        }
    }

    public Collection<Jogador> findAll() {
        return repository.findAll();
    }

    public Collection<?> findByIntervaloMes(Integer id_jogador, Integer dia) {
        return repository.findByIntervaloMes(id_jogador, dia);
    }

    public Collection<?> findRankingByAssistencias() {
        return repository.findRankingByAssistencias();
    }

    public Collection<?> findRankingByGols() {
        return repository.findRankingByGols();
    }

    public Jogador findLoginJogador(String email, String senha) {
        return repository.findLoginJogador(email, senha);
    }

    public Collection<?> findByJogadorInReservaGrupo(Integer id_jogador) {
        return repository.findByJogadorInReservaGrupo(id_jogador);
    }

    public Float findByMediaJogador(Integer id_jogador) {
        return reservaIndividualRepository.findByMediaJogador(id_jogador);
    }

    public Integer findByAdvertenciaJogador(Integer id_jogador) {
        return avaliacaoRepository.findByAdvertenciaJogador(id_jogador);
    }

    public Jogador insert(Jogador obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Jogador não foi(foram) preenchido(s)");
        }
    }

    public Jogador update(Jogador obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Jogador não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Jogador vinculada a uma pelada!");
        }
    }

}
