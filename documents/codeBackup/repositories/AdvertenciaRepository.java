package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Advertencia;
import les.ifoot.model.AdvertenciaPK;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, AdvertenciaPK> {

}
