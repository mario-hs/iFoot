package les.ifoot.services;

import java.util.NoSuchElementException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.ifoot.model.Horario;
import les.ifoot.repositories.HorarioRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository repository;

    public Horario findById(Integer id) {
        try {
            Horario obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Horario.class.getName());
        }
    }

    public Collection<Horario> findAll() {
        return repository.findAll();
    }

    public Horario insert(final Horario obj) {
        try {
            obj.setId(null);
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) do Horario não foi(foram) preenchido(s)");
        }
    }

    public Horario update(Horario obj) {
        try {
            findById(obj.getId());
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) do Horario não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        try {
            findById(id);
            repository.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Horario!");
        }
    }

}
