package les.ifoot.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import les.ifoot.model.Campo;
import les.ifoot.repositories.CampoRepository;
import les.ifoot.services.exceptions.DataIntegrityException;

@Service
public class CampoService {
    @Autowired
    private CampoRepository repository;

    public Campo findById(final Integer id) {
        try {
            Campo obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new les.ifoot.services.exceptions.ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Campo.class.getName());
        }
    }

    public Collection<Campo> findAll() {
        return repository.findAll();
    }

    public Campo insert(final Campo obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Campo não foi(foram) preenchido(s)");
        }
    }

    public Campo update(final Campo obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Campo não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir este campo pois ele tem horário(s) cadastrado(s)!");
        }
    }

    public Collection<Campo> findAllCampoEspaco(Integer id_espaco) {
        return repository.findAllCampoEspaco(id_espaco);
    }

    public Collection<Campo> findByTipoPiso(Integer tipo_campo) {
        return repository.findByTipoPiso(tipo_campo);
    }

    public Collection<Campo> findByTipoPisoAll() {
        return repository.findByTipoPisoAll();
    }
}
