package les.ifoot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import les.ifoot.model.ReservaIndividual;

@Repository
public interface ReservaIndividualRepository extends JpaRepository<ReservaIndividual, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "CREATE OR REPLACE FUNCTION porcentagem(IN cod numeric) RETURNS float AS $$ DECLARE valor_campo float; valor_jogador float; porcentagem float; BEGIN select ca.valor_unit from campo ca where ca.id = cod and ca.valor_unit > 0 into valor_campo; select j.carteira from jogador j into valor_jogador; porcentagem = (valor_campo * 10)/100; if (porcentagem < valor_jogador) then return porcentagem; else return porcentagem; end if; END; $$ LANGUAGE plpgsql; SELECT * from porcentagem(?1);", nativeQuery = true)
    public Float findByPorcentoValorCampo(Integer id_campo);

}
