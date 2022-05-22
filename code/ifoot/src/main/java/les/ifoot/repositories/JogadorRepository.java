package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

}
