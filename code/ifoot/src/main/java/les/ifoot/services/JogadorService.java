package les.ifoot.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Jogador;
import les.ifoot.repositories.JogadorRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
    // @Autowired
    // private JogadorRepository repository;

    // public Jogador findById(Integer id) {
    // return repository.findById(id).get();
    // }

    // public List<Jogador> findAll() {
    // return repository.findAll();
    // }

    // public Jogador insert(Jogador obj) {
    // return repository.save(obj);
    // }

    // public Jogador update(Jogador obj) {
    // findById(obj.getId());
    // return repository.save(obj);
    // }

    // public void delete(Integer id) {
    // findById(id);
    // repository.deleteById(id);
    // }

    @Autowired
    private JogadorRepository repository;

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

    // public Collection<Jogador> findByDanificadaAndDisponivel(Boolean danificada,
    // Boolean disponivel) {
    // return repository.findByDanificadaAndDisponivel(danificada, disponivel);
    // }

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
            throw new DataIntegrityException("Não é possível excluir uma Jogador vinculada a Itens de Empréstimos!");
        }
    }

    // public Collection<Jogador> findByFilme(Filme obj) {
    // return repository.findByFilme(obj);
    // }
}
