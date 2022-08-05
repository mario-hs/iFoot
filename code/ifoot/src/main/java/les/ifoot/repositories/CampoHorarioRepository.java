package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.CampoHorario;

@Repository
public interface CampoHorarioRepository extends JpaRepository<CampoHorario, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM campo_horario ch " +
            "INNER JOIN campo cp ON ch.campo_id = cp.id " +
            "INNER JOIN horario h ON ch.horario_id = h.id " +
            "INNER JOIN espaco e ON cp.espaco_id = e.id " +
            "WHERE e.id = ?1", nativeQuery = true)
    public Collection<CampoHorario> findAllDataEspaco(Integer id_espaco);

}
