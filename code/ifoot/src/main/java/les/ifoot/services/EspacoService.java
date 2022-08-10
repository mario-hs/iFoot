package les.ifoot.services;

import java.util.NoSuchElementException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Espaco;
import les.ifoot.repositories.EspacoRepository;
import les.ifoot.repositories.CampoHorarioRepository;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class EspacoService {
    @Autowired
    private EspacoRepository repository;

    @Autowired
    private CampoHorarioRepository campoHorarioRepository;

    public Espaco findById(final Integer id) {
        try {
            Espaco obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Espaco.class.getName());
        }
    }

    public Collection<Espaco> findAll() {
        return repository.findAll();
    }

    public Espaco insert(final Espaco obj) {
        obj.setId(null);
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Espaço não foi(foram) preenchido(s)");
        }
    }

    public Espaco update(final Espaco obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Espaço não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir esse espaço por conta de uma de alguma associação!");
        }
    }

    public Collection<?> findByQTDTipoByAnoAndMes(Integer ano, Integer mes) {
        return repository.findByQTDTipoByAnoAndMes(ano, mes);
    }

    public Collection<?> findAllDataEspaco(Integer id_espaco) {
        return campoHorarioRepository.findAllDataEspaco(id_espaco);
    }

    public Collection<?> findByTipoPiso(Integer tipo_campo) {
        return repository.findByTipoPiso(tipo_campo);
    }

    public Collection<?> findByTipoPisoAll() {
        return repository.findByTipoPisoAll();
    }

    public Collection<?> findLucroByMesAno(Integer id_espaco, Integer tipo_campo, Integer ano) {
        return repository.findLucroByMesAno(id_espaco, tipo_campo, ano);
    }

    public Espaco findLoginEspaco(String email, String senha) {
        return repository.findLoginEspaco(email, senha);
    }
}
