package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.CampoHorario;
import les.ifoot.model.CampoHorarioPK;

@Repository
public interface CampoHorarioRepository extends JpaRepository<CampoHorario, CampoHorarioPK> {

}
