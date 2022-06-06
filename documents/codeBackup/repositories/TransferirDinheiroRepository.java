package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.TransferirDinheiro;

@Repository
public interface TransferirDinheiroRepository extends JpaRepository<TransferirDinheiro, Integer> {

}