package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
        @Transactional(readOnly = true)
        @Query(value = "SELECT " +

                        "(SELECT COUNT(pelada_jogador_by_mes) AS participacao FROM " +
                        "(SELECT DATE_PART('MONTH', pl.data_pelada) as mes, * FROM participacao_lista_jogador plj " +
                        "INNER JOIN participacao pp  ON plj.participacao_id = pp.id " +
                        "INNER JOIN pelada pl        ON pp.pelada_id = pl.id " +
                        "INNER JOIN reserva_grupo rg  ON pl.reserva_grupo_id = rg.id " +
                        "INNER JOIN reserva_grupo_jogador rgj  ON rgj.reserva_grupo_id = rg.id " +
                        "INNER JOIN jogador j        ON rgj.jogador_id = j.id " +
                        "WHERE plj.jogador_id = j.id " +
                        "AND j.id = ?1 " +
                        "AND pl.reserva_grupo_id = rgj.reserva_grupo_id) as pelada_jogador_by_mes " +
                        "WHERE pelada_jogador_by_mes.mes = ?2), " +

                        "(SELECT SUM(pelada_jogador_by_mes.gol) AS qtdGols FROM " +
                        "(SELECT DATE_PART('MONTH', pl.data_pelada) as mes, * FROM pelada pl " +
                        "INNER JOIN reserva_grupo_jogador rgj ON pl.reserva_grupo_id = rgj.reserva_grupo_id " +
                        "INNER JOIN reserva_grupo rg ON rgj.reserva_grupo_id = rg.id " +
                        "INNER JOIN jogador j        ON rgj.jogador_id = j.id " +
                        "WHERE j.id = ?1 " +
                        "AND pl.reserva_grupo_id = rgj.reserva_grupo_id) as pelada_jogador_by_mes " +
                        "WHERE pelada_jogador_by_mes.mes = ?2), " +

                        "(SELECT SUM(pelada_jogador_by_mes.assistencia) AS qtdAssistencias FROM " +
                        "(SELECT DATE_PART('MONTH', pl.data_pelada) as mes, * FROM pelada pl " +
                        "INNER JOIN reserva_grupo_jogador rgj ON pl.reserva_grupo_id = rgj.reserva_grupo_id " +
                        "INNER JOIN reserva_grupo rg ON rgj.reserva_grupo_id = rg.id " +
                        "INNER JOIN jogador j        ON rgj.jogador_id = j.id " +
                        "WHERE j.id = ?1 " +
                        "AND pl.reserva_grupo_id = rgj.reserva_grupo_id) as pelada_jogador_by_mes " +
                        "WHERE pelada_jogador_by_mes.mes = ?2), " +

                        "(SELECT SUM(pelada_jogador_by_mes.qtd_advertencia) AS qtdAdvertencias FROM " +
                        "(SELECT DATE_PART('MONTH', pl.data_pelada) as mes, * FROM pelada pl " +
                        "INNER JOIN reserva_grupo_jogador rgj ON pl.reserva_grupo_id = rgj.reserva_grupo_id " +
                        "INNER JOIN reserva_grupo rg ON rgj.reserva_grupo_id = rg.id " +
                        "INNER JOIN jogador j        ON rgj.jogador_id = j.id " +
                        "WHERE j.id = ?1 " +
                        "AND pl.reserva_grupo_id = rgj.reserva_grupo_id) as pelada_jogador_by_mes " +
                        "WHERE pelada_jogador_by_mes.mes = ?2)", nativeQuery = true)
        public Collection<?> findByIntervaloMes(Integer id_jogador, Integer mes);

        @Transactional(readOnly = true)
        @Query(value = "SELECT (SELECT COUNT(jogador) FROM jogador) as qtd, j.nome, j.assistencia " +
                        "FROM jogador j " +
                        "ORDER BY j.assistencia DESC", nativeQuery = true)
        public Collection<?> findRankingByAssistencias();

        @Transactional(readOnly = true)
        @Query(value = "SELECT (SELECT COUNT(jogador) FROM jogador) as qtd, j.nome, j.gol " +
                        "FROM jogador j " +
                        "ORDER BY j.gol DESC", nativeQuery = true)
        public Collection<?> findRankingByGols();

        @Transactional(readOnly = true)
        // @Query(value = "SELECT e.nome_espaco, cp.nome_campo, cp.tipo_campo,
        // h.dia_semana, h.status, e.bairro, pl.data_pelada, h.hora "
        @Query(value = "SELECT e.nome_espaco as espaco, cp.nome_campo as nome_campo, cp.tipo_campo as tipo, h.dia_semana as dia, h.status as status, e.bairro as bairro, pl.data_pelada as data_pelada, h.hora as hora "
                        // @Query(value = "SELECT * "
                        +
                        "FROM pelada pl " +
                        "INNER JOIN reserva_grupo rg ON pl.reserva_grupo_id = rg.id " +
                        "INNER JOIN reserva_grupo_jogador rgj ON rgj.reserva_grupo_id = rg.id " +
                        "INNER JOIN jogador j ON rgj.jogador_id = j.id " +
                        "INNER JOIN campo_horario ch ON rg.campo_horario_id = ch.id " +
                        "INNER JOIN horario h ON ch.horario_id = h.id " +
                        "INNER JOIN campo cp ON ch.campo_id = cp.id " +
                        "INNER JOIN espaco e ON cp.espaco_id = e.id " +
                        "WHERE j.id = ?1", nativeQuery = true)
        public Collection<?> findByJogadorInReservaGrupo(Integer id_jogador);

}
