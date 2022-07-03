package les.ifoot.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import les.ifoot.model.TransferirDinheiro;

@Repository
public interface TransferirDinheiroRepository extends JpaRepository<TransferirDinheiro, Integer> {
    Date data = new Date(System.currentTimeMillis());

    @Transactional(readOnly = true)
    // @Query(value = "SELECT nome, data_transferencia, SUM(td.valor) as 'qtd' FROM
    // transferir_dinheiro td, jogador j WHERE td.jogador_remetente_id = j.id AND
    // td.data_transferencia = ?1 AND j.id = ?2 GROUP BY td.data_transferencia,
    // j.nome", nativeQuery = true)
    @Query(value = "SELECT FROM transferir_dinheiro td, jogador j WHERE td.jogador_remetente_id = j.id AND td.data_transferencia = ?1 AND j.id = ?2 HAVING SUM(td.valor) < 50", nativeQuery = true)
    public TransferirDinheiro findByDataTransferencia(Date data, Integer id_jogador);

}