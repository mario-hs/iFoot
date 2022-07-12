package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.TransferenciaEspaco;

@Repository
public interface TransferenciaEspacoRepository extends JpaRepository<TransferenciaEspaco, Integer> {

}