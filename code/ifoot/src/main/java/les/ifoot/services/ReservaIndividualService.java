package les.ifoot.services;

// import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import les.ifoot.model.ReservaIndividual;
import les.ifoot.repositories.ReservaIndividualRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
import les.ifoot.services.exceptions.DataIntegrityException;
import les.ifoot.services.exceptions.ObjectNotFoundException;

@Service
public class ReservaIndividualService {
    @Autowired
    private ReservaIndividualRepository repository;

    public ReservaIndividual findById(Integer id) {
        try {
            ReservaIndividual obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + ReservaIndividual.class.getName());
        }
    }

    public Collection<ReservaIndividual> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ReservaIndividual insert(ReservaIndividual obj) {
        try {
            if (handleReservaIndividual(obj) == true) {
                return repository.save(obj);
            }
            throw new BusinessRuleException("Avaliação não pode ser efetuada");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da ReservaIndividual não foi(foram) preenchido(s)");
        }
    }

    public ReservaIndividual update(ReservaIndividual obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Campo(s) obrigatório(s) da ReservaIndividual não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir uma ReservaIndividual vinculada a Itens de Empréstimos!");
        }
    }

    // FEITO POR ANTONIELLY
    public boolean handleReservaIndividual(ReservaIndividual obj) {
        Integer id_campo = obj.getPelada().getReservaGrupo().getCampoHorario().getCampo().getId();
        Double carteira = obj.getJogador().getCarteira();
        Float porcento_valor_unit = repository.findByPorcentoValorCampo(id_campo);
        System.out.println(porcento_valor_unit);
        System.out.println(carteira);
        System.out.println(id_campo);

        Integer id_reserva_grupo = obj.getPelada().getReservaGrupo().getId();
        Integer id_jogador = obj.getJogador().getId();
        System.out.println();
        System.out.println(id_reserva_grupo);
        System.out.println(id_jogador);
        Float media_nota_reserva_grupo = repository.findByMediaReservaGrupo(id_reserva_grupo);
        Float media_nota_jogador = repository.findByMediaJogador(id_jogador);
        System.out.println(media_nota_reserva_grupo);
        System.out.println(media_nota_jogador);
        System.out.println();

        if (carteira < porcento_valor_unit) {
            throw new BusinessRuleException(
                    "Você não tem dinheiro em sua carteira o suficiente para realizar está reserva!");
        }

        if (media_nota_jogador < media_nota_reserva_grupo) {
            throw new BusinessRuleException(
                    "Você não pode realizar reserva neste grupo! Seu score é a baixo do score do grupo!");
        }

        return true;
    }

}
