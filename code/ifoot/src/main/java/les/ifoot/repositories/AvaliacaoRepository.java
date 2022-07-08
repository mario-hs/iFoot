package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Avaliacao;

// FEITO POR MARIO
@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT SUM(pn.qtd_amarelo) FROM penalidade pn, jogador j WHERE pn.jogador_id = j.id AND j.id = ?1", nativeQuery = true)
    public Integer findByAdvertenciaJogador(Integer id_jogador);

    @Transactional(readOnly = true)
    @Query(value = "SELECT CURRENT_DATE", nativeQuery = true)
    public Date findByDataAtual();

    @Transactional(readOnly = true)
    @Query(value = "SELECT pl.data_pelada FROM participacao pp INNER JOIN jogador j ON pp.jogador_id = j.id INNER JOIN pelada pl ON pp.pelada_id = pl.id INNER JOIN reserva_grupo rg ON pl.reserva_grupo_id = rg.id INNER JOIN campo_horario ch ON rg.campo_horario_id = ch.id INNER JOIN horario h ON ch.horario_id = h.id WHERE pp.id = ?1", nativeQuery = true)
    public Date findByParticipacaoPelada(Integer id_pelada);
}
