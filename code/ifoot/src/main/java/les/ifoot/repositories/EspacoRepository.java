package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Integer> {

}
