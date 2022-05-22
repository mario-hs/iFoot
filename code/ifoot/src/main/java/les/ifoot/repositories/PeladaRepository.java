package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Pelada;

@Repository
public interface PeladaRepository extends JpaRepository<Pelada, Integer> {

}
