package les.ifoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import les.ifoot.model.Advertencia;
import les.ifoot.repositories.AdvertenciaRepository;

@Service
public class AdvertenciaService {
@Autowired
    private AdvertenciaRepository repository;
public Advertencia findById(final Integer id) {
        try {
            Advertencia obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new les.ifoot.services.exceptions.ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Advertencia.class.getName());
        }
    }

public Collection<Advertencia> findAll() {
        return repository.findAll();
    }

public Advertencia insert(final Advertencia obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Advertência não foi(foram) preenchido(s)");
        }
    }

public Advertencia update(final Advertencia obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de Advertência não foi(foram) preenchido(s)");
        }
    }

public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir esta Advertência pois ele está cadastrado em algum outro campo");
        }
    }
}