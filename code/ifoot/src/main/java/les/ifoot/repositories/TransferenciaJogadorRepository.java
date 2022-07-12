package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.TransferenciaJogador;

// FEITO POR VICENZO
@Repository
public interface TransferenciaJogadorRepository extends JpaRepository<TransferenciaJogador, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) < 3 FROM transferencia_jogador td, jogador j WHERE td.jogador_remetente_id = j.id AND td.data_transferencia = ?1 AND j.id = ?2 ", nativeQuery = true)
    public boolean findByDataLimiteDiarioQuantidade(String data, Integer idJogador);

    @Transactional(readOnly = true)
    @Query(value = "SELECT SUM(td.valor) FROM transferencia_jogador td, jogador j WHERE td.jogador_remetente_id= j.id AND td.data_transferencia = ?1 AND j.id= ?2 HAVING SUM(td.valor) <= 50", nativeQuery = true)
    public double findByDataLimiteDiarioValor(String data, Integer idJogador);

}
