package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.ReservaGrupo;
import les.ifoot.model.ReservaGrupoPK;

@Repository
public interface ReservaGrupoRepository extends JpaRepository<ReservaGrupo, ReservaGrupoPK> {

}
