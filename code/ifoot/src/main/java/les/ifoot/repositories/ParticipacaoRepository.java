package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.ifoot.model.Participacao;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

}
