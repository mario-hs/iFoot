package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Advertencia;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, Integer> {

}
