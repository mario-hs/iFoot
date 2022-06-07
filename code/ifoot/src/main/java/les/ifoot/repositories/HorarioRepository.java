package les.ifoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les.ifoot.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}
