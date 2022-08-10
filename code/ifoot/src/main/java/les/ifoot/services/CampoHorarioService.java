package les.ifoot.services;

import java.util.Collection;
// import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.CampoHorario;
import les.ifoot.repositories.CampoHorarioRepository;
import les.ifoot.services.exceptions.DataIntegrityException;

@Service
public class CampoHorarioService {

    @Autowired
    private CampoHorarioRepository repository;

    public CampoHorario findById(final Integer id) {
        try {
            CampoHorario obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new les.ifoot.services.exceptions.ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + CampoHorario.class.getName());
        }
    }

    public Collection<CampoHorario> findAll() {
        return repository.findAll();
    }

    public Collection<CampoHorario> findAllDataEspaco(Integer id_espaco) {
        return repository.findAllDataEspaco(id_espaco);
    }

    public CampoHorario insert(final CampoHorario obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do CampoHorario não foi(foram) preenchido(s)");
        }
    }

    public CampoHorario update(final CampoHorario obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de CampoHorario não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir este horário do campo pois ele têm alguma pendência!");
        }
    }

}
