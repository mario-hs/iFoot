package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.ReservaGrupo;

// FEITO POR PATRICK
@Repository
public interface ReservaGrupoRepository extends JpaRepository<ReservaGrupo, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) > 0 FROM pelada pl INNER JOIN reserva_grupo rg ON pl.reserva_grupo_id = rg.id INNER JOIN reserva_grupo_jogador rgj ON rgj.reserva_grupo_id = rg.id INNER JOIN jogador j ON rgj.jogador_id = j.id INNER JOIN campo_horario ch ON rg.campo_horario_id = ch.id INNER JOIN horario h ON ch.horario_id = h.id WHERE j.id = ?1 AND pl.data_pelada = ?2 AND h.hora = ?3", nativeQuery = true)
    public Boolean findByJogadorDataPeladaHorario(Integer id_jogador, Date data, String hora);

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(pn.qtd_vermelho) FROM jogador j, penalidade pn WHERE ?1 = j.id AND j.id = pn.jogador_id AND pn.qtd_vermelho = 1", nativeQuery = true)
    public Integer findByQtdJogadorComVermelho(Integer id_jogador);

}