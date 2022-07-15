package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT(SELECT COUNT(futsal_ano_mes) AS qtdFutsal " +
            "FROM (SELECT DATE_PART('MONTH', pl.data_pelada) AS mes, DATE_PART('YEAR', pl.data_pelada) AS ano, * " +
            "FROM pelada pl " +
            "INNER JOIN reserva_grupo AS rg ON pl.reserva_grupo_id = rg.id " +
            "INNER JOIN campo_horario AS ch ON rg.campo_horario_id = ch.id " +
            "INNER JOIN campo AS cp ON ch.campo_id = cp.id " +
            "WHERE cp.tipo_campo = 1) AS futsal_ano_mes " +
            "WHERE futsal_ano_mes.mes = ?2 AND futsal_ano_mes.ano = ?1), " +
            "(SELECT COUNT(society_ano_mes) AS qtdSociety " +
            "FROM (SELECT DATE_PART('MONTH', pl.data_pelada) AS mes, DATE_PART('YEAR', pl.data_pelada) AS ano, * " +
            "FROM pelada pl " +
            "INNER JOIN reserva_grupo AS rg ON pl.reserva_grupo_id = rg.id " +
            "INNER JOIN campo_horario AS ch ON rg.campo_horario_id = ch.id " +
            "INNER JOIN campo AS cp ON ch.campo_id = cp.id " +
            "WHERE cp.tipo_campo = 2) AS society_ano_mes " +
            "WHERE society_ano_mes.mes = ?2 AND society_ano_mes.ano = ?1), " +
            "(SELECT COUNT(campo_ano_mes) AS qtdCampo " +
            "FROM (SELECT DATE_PART('MONTH', pl.data_pelada) AS mes, DATE_PART('YEAR', pl.data_pelada) AS ano, * " +
            "FROM pelada pl " +
            "INNER JOIN reserva_grupo AS rg ON pl.reserva_grupo_id = rg.id " +
            "INNER JOIN campo_horario AS ch ON rg.campo_horario_id = ch.id " +
            "INNER JOIN campo AS cp ON ch.campo_id = cp.id " +
            "WHERE cp.tipo_campo = 3) AS campo_ano_mes " +
            "WHERE campo_ano_mes.mes = ?2 AND campo_ano_mes.ano = ?1) ", nativeQuery = true)
    public Collection<?> findByQTDTipoByAnoAndMes(Integer ano, Integer mes);

    @Transactional(readOnly = true)
    @Query(value = "SELECT (SELECT COUNT (*) FROM campo WHERE campo.tipo_campo = ?1), " +
            "e.nome_espaco, cp.tipo_campo, cp.nome_campo, cp.valor_ano, cp.valor_mes, cp.valor_unit " +
            "FROM espaco e " +
            "INNER JOIN campo cp ON cp.espaco_id = e.id " +
            "WHERE cp.tipo_campo = ?1", nativeQuery = true)
    public Collection<?> findByTipoPiso(Integer tipo_campo);

    @Transactional(readOnly = true)
    @Query(value = "SELECT (SELECT COUNT (*) FROM campo), " +
            "e.nome_espaco, cp.tipo_campo, cp.nome_campo, cp.valor_ano, cp.valor_mes, cp.valor_unit " +
            "FROM espaco e INNER JOIN campo cp ON cp.espaco_id = e.id ", nativeQuery = true)
    public Collection<?> findByTipoPisoAll();

    @Transactional(readOnly = true)
    @Query(value = "SELECT te.data_transferencia_espaco, te.valor, e.carteira, cp.nome_campo, cp.tipo_campo " +
            "FROM transferencia_espaco te " +
            "INNER JOIN espaco e ON te.espaco_id = e.id " +
            "INNER JOIN campo cp ON cp.espaco_id = e.id " +
            "WHERE DATE_PART('MONTH', te.data_transferencia_espaco) = ?3 " +
            "AND  DATE_PART('YEAR', te.data_transferencia_espaco) = ?4 " +
            "AND  cp.tipo_campo = ?2 " +
            "AND  te.espaco_id = ?1", nativeQuery = true)
    public Collection<?> findLucroByMesAno(Integer id_espaco, Integer tipo_campo, Integer mes, Integer ano);

}
