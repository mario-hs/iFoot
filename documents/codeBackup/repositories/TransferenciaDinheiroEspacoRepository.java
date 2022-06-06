package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.TransferenciaDinheiroEspaco;

@Repository
public interface TransferenciaDinheiroEspacoRepository extends JpaRepository<TransferenciaDinheiroEspaco, Integer> {

}