package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Posicao;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao, Integer> {

}