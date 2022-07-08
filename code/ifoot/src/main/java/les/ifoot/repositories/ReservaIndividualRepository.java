package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.ReservaIndividual;

// FEITO POR ANTONIELLY
@Repository
public interface ReservaIndividualRepository extends JpaRepository<ReservaIndividual, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT AVG(ca.valor_unit * 0.1) FROM campo ca WHERE ca.id = ?1", nativeQuery = true)
    public Float findByPorcentoValorCampo(Integer id_campo);

    @Transactional(readOnly = true)
    @Query(value = "SELECT AVG(av.nota) FROM reserva_grupo_jogador rgj INNER JOIN avaliacao av ON av.id_jogador_avaliado = rgj.jogador_id WHERE rgj.reserva_grupo_id = ?1", nativeQuery = true)
    public Float findByMediaReservaGrupo(Integer id_reserva_grupo);

    @Transactional(readOnly = true)
    @Query(value = "SELECT AVG(av.nota) FROM avaliacao av WHERE av.id_jogador_avaliado = ?1", nativeQuery = true)
    public Float findByMediaJogador(Integer id_jogador);
}
