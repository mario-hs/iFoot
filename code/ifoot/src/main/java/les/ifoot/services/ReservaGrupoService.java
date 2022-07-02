package les.ifoot.services;

import java.util.List;
// import java.util.NoSuchElementException;

// import org.hibernate.ObjectNotFoundException;
// import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import les.ifoot.model.Campo;
// import les.ifoot.model.CampoHorario;
// import les.ifoot.model.Horario;
import les.ifoot.model.ReservaGrupo;
// import les.ifoot.repositories.CampoHorarioRepository;
// import les.ifoot.repositories.CampoRepository;
// import les.ifoot.repositories.HorarioRepository;
// import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.repositories.ReservaGrupoRepository;

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
        obj.setId(null);
        try {
            return repository.save(obj);
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
                    "Não é possível excluir uma ReservaGrupo vinculada a Itens de Empréstimos!");
        }
    }


}

// @Service
// public class ReservaGrupoService {
// @Autowired
// private ReservaGrupoRepository reservaGrupoRepository;

// @Autowired
// private HorarioRepository horarioRepository;

// @Autowired
// private CampoRepository campoRepository;

// @Autowired
// private CampoHorarioRepository campoHorarioRepository;

// public ReservaGrupo findById(Integer idCampo, Integer idHorario) {
// Campo campo = new Campo();
// Horario horario = new Horario();
// CampoHorario campoHorario = new CampoHorario();
// ReservaGrupoPK id = new ReservaGrupoPK();

// campo = campoRepository.findById(idCampo).get();
// horario = horarioRepository.findById(idHorario).get();
// campoHorario.getId().setCampo(campo);
// campoHorario.getId().setHorario(horario);
// campoHorario = campoHorarioRepository.findById(campoHorario.getId()).get();
// id.setCampoHorario(campoHorario);

// try {
// ReservaGrupo obj = reservaGrupoRepository.findById(id).get();
// return obj;
// } catch (NoSuchElementException e) {
// throw new ObjectNotFoundException(
// "Objeto não encontrado! Id: " + id + ", Tipo: " +
// ReservaGrupo.class.getName(),
// ReservaGrupo.class.getName());
// }
// }

// public ReservaGrupo findById(ReservaGrupoPK id) {
// ReservaGrupo obj = reservaGrupoRepository.findById(id).get();
// if (obj == null) {
// throw new ObjectNotFoundException(
// "Objeto não encontrado! Id: " + id + ", Tipo: " +
// ReservaGrupo.class.getName(),
// ReservaGrupo.class.getName());
// }
// return obj;
// }

// public List<ReservaGrupo> findAll() {
// // public Collection<ReservaGrupo> findAll() {
// return reservaGrupoRepository.findAll();
// }

// public ReservaGrupo insert(ReservaGrupo obj) {
// try {
// return reservaGrupoRepository.save(obj);
// } catch (DataIntegrityViolationException e) {
// throw new DataIntegrityException(
// "Campo(s) obrigatório(s) da ReservaGrupo não foi(foram) preenchido(s):
// CampoHorario (Campo e/ou Horario)");
// }
// }

// public ReservaGrupo update(ReservaGrupo obj) {
// findById(obj.getId());
// try {
// return reservaGrupoRepository.save(obj);
// } catch (DataIntegrityViolationException e) {
// throw new DataIntegrityException(
// "Campo(s) obrigatório(s) da ReservaGrupo não foi(foram) preenchido(s):
// CampoHorario (Campo e/ou Horario)");
// }
// }

// public void delete(Integer idCampo, Integer idHorario) {
// ReservaGrupo reservaGrupo = findById(idCampo, idHorario);
// try {
// reservaGrupoRepository.deleteById(reservaGrupo.getId());
// } catch (DataIntegrityViolationException e) {
// throw new DataIntegrityException("Não é possível excluir esta Reserva em
// Grupo");
// }
// }
// }