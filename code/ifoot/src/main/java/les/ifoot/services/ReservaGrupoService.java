package les.ifoot.services;

import java.sql.Date;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.ifoot.model.Jogador;
import les.ifoot.model.ReservaGrupo;
import les.ifoot.repositories.ReservaGrupoRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class ReservaGrupoService {
    @Autowired
    private ReservaGrupoRepository repository;

    public ReservaGrupo findById(Integer id) {
        try {
            ReservaGrupo obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + ReservaGrupo.class.getName());
        }
    }

    public Collection<ReservaGrupo> findAll() {
        return repository.findAll();
    }

    public ReservaGrupo insert(ReservaGrupo obj) {
        try {
            if (handleReservaGrupo(obj) == true) {
                return repository.save(obj);
            }
            throw new BusinessRuleException("Avaliação não pode ser efetuada");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da ReservaGrupo não foi(foram) preenchido(s)");
        }
    }

    public ReservaGrupo update(ReservaGrupo obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da ReservaGrupo não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma ReservaGrupo vinculada com jogador na reserva!");
        }
    }

    // FEITO POR PATRICK
    public boolean handleReservaGrupo(ReservaGrupo obj) {
        Date data = new Date(121, 06, 26);
        String hora = "19:00"; // pegar o horario do campo

        Collection<Jogador> listJogadores = obj.getJogador();

        for (Jogador jogador : listJogadores) {
            System.out.println(repository.findByJogadorDataPeladaHorario(jogador.getId(), data, hora));
            System.out.println(data);
            if (repository.findByJogadorDataPeladaHorario(jogador.getId(), data, hora)) {
                throw new BusinessRuleException("O jogador " + jogador.getNome()
                        + " não pode participar desta pelada, pois ele já se encontra em outra no mesmo horário!");
            }

            if (repository.findByQtdJogadorComVermelho(jogador.getId()) > 0) {
                throw new BusinessRuleException(
                        "Não pode ser registrado a pelada! O jogador " + jogador.getNome()
                                + " está punido com cartão vermelho!");
            }
        }

        return true;
    }
}
