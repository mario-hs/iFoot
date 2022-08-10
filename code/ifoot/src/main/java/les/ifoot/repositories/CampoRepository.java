package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Campo;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM campo cp " +
            "INNER JOIN espaco e ON cp.espaco_id = e.id " +
            "WHERE e.id = ?1", nativeQuery = true)
    public Collection<Campo> findAllCampoEspaco(Integer id_espaco);

    @Transactional(readOnly = true)
    @Query(value = "SELECT (SELECT COUNT (*) FROM campo WHERE campo.tipo_campo = ?1),  * " +
            "FROM campo cp " +
            "INNER JOIN espaco e ON cp.espaco_id = e.id " +
            "WHERE cp.tipo_campo = ?1 ", nativeQuery = true)
    public Collection<Campo> findByTipoPiso(Integer tipo_campo);

    @Transactional(readOnly = true)
    @Query(value = "SELECT (SELECT COUNT (*) FROM campo), * " +
            "FROM campo cp INNER JOIN espaco e ON cp.espaco_id = e.id ", nativeQuery = true)
    public Collection<Campo> findByTipoPisoAll();
}
