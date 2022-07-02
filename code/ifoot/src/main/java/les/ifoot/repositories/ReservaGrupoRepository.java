package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.ReservaGrupo;

@Repository
    public interface ReservaGrupoRepository extends JpaRepository<ReservaGrupo, Integer> {
}