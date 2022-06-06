package les.ifoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import les.ifoot.model.Advertencia;
import les.ifoot.model.AdvertenciaPK;
import les.ifoot.model.Jogador;
import les.ifoot.model.Participacao;
import les.ifoot.model.Pelada;
import les.ifoot.repositories.AdvertenciaRepository;
import les.ifoot.repositories.JogadorRepository;
import les.ifoot.repositories.ParticipacaoRepository;
import les.ifoot.repositories.PeladaRepository;
import les.ifoot.services.exceptions.DataIntegrityException;

// @Service
// public class AdvertenciaService {
//     @Autowired
//     private AdvertenciaRepository repository;

//     public Advertencia findById(Integer id) {
//         try {
//             Advertencia obj = repository.findById(id).get();
//             return obj;
//         } catch (NoSuchElementException e) {
//             throw new ObjectNotFoundException("Objeto não encontrado" + id, ", tipo: " + Advertencia.class);
//         }
//     }

//     public List<Advertencia> findAll() {
//         return repository.findAll();
//     }

//     public Advertencia insert(Advertencia obj) {
//         return repository.save(obj);
//     }

//     public Advertencia update(Advertencia obj) {
//         findById(obj.getId());
//         return repository.save(obj);
//     }

//     public void delete(Integer id) {
//         findById(id);
//         repository.deleteById(id);
//     }
// }

@Service
public class AdvertenciaService {

    @Autowired
    private AdvertenciaRepository advertenciaRepository;
    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private PeladaRepository peladaRepository;
    @Autowired
    private ParticipacaoRepository participacaoRepository;

    public Advertencia findById(Integer idJogador, Integer idPelada) {
        Jogador jogador = new Jogador();
        Pelada pelada = new Pelada();
        Participacao participacao = new Participacao();
        AdvertenciaPK id = new AdvertenciaPK();

        jogador = jogadorRepository.findById(idJogador).get();
        pelada = peladaRepository.findById(idPelada).get();
        participacao.getId().setJogador(jogador);
        participacao.getId().setPelada(pelada);
        participacao = participacaoRepository.findById(participacao.getId()).get();
        id.setParticipacao(participacao);

        try {
            Advertencia obj = advertenciaRepository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Advertencia.class.getName(),
                    Advertencia.class.getName());
        }
    }

    public Advertencia findById(AdvertenciaPK id) {
        Advertencia obj = advertenciaRepository.findById(id).get();
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Advertencia.class.getName(),
                    Advertencia.class.getName());
        }
        return obj;
    }

    // public Collection<Advertencia> findAll() {
    // return advertenciaRepository.findAll();
    // }

    public Advertencia insert(Advertencia obj) {
        try {
            return advertenciaRepository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da Advertencia não foi(foram) preenchido(s): Item de Empréstimo (Empréstimo e/ou Pelada)");
        }
    }

    public Advertencia update(Advertencia obj) {
        findById(obj.getId());
        try {
            return advertenciaRepository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da Advertencia não foi(foram) preenchido(s): Item de Empréstimo (Empréstimo e/ou Pelada)");
        }
    }

    public void delete(Integer idJogador, Integer idPelada) {
        Advertencia advertencia = findById(idJogador, idPelada);
        try {
            advertenciaRepository.deleteById(advertencia.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir esta Multa");
        }
    }

}
