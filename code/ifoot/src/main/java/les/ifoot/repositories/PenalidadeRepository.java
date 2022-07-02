package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Penalidade;

@Repository
public interface PenalidadeRepository extends JpaRepository<Penalidade, Integer> {

}
