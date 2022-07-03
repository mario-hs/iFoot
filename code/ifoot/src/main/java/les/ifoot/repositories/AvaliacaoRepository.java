package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT SUM(pn.qtd_amarelo) FROM penalidade pn, jogador j WHERE pn.jogador_id = j.id AND j.id = ?1", nativeQuery = true)
    public boolean findByAdvertenciaJogador(Integer id_jogador);
}
