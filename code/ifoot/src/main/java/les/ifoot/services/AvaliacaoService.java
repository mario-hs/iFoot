package les.ifoot.services;

import java.text.SimpleDateFormat;
// import java.util.List;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import les.ifoot.model.Avaliacao;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.services.exceptions.BusinessRuleException;
import les.ifoot.services.exceptions.DataIntegrityException;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao findById(final Integer id) {
        try {
            Avaliacao obj = repository.findById(id).get();
            return obj;
        } catch (NoSuchElementException e) {
            throw new les.ifoot.services.exceptions.ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Avaliacao.class.getName());
        }
    }

    public Collection<Avaliacao> findAll() {
        return repository.findAll();
    }

    public Avaliacao insert(final Avaliacao obj) {
        try {
            if (handleAvaliacao(obj) == true) {

                // Jogador jogador = obj.getJogador_avaliado();
                // jogador.setScore(score);
                // repositoryJogador.save(jogador);
                // Exemplo de como atualizar alguma coisa modificada

                return repository.save(obj);
            }
            throw new BusinessRuleException("Avaliação não pode ser efetuada");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Avaliacao não foi(foram) preenchido(s)");
        }
    }

    public Avaliacao update(final Avaliacao obj) {
        findById(obj.getId());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de Avaliacao não foi(foram) preenchido(s)");
        }
    }

    public void delete(final Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir esta Avaliacao pois ele está cadastrado em algum outro campo");
        }
    }

    // FEITO POR MARIO
    public boolean handleAvaliacao(Avaliacao obj) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Integer id_jogador = obj.getJogador_avaliador().getId();
        Integer qtd_amarelo = repository.findByAdvertenciaJogador(id_jogador);

        Integer id_Participacao = obj.getParticipacao().getId();
        Date dia_atual = repository.findByDataAtual();
        String dia_pelada = repository.findByParticipacaoPelada(id_Participacao);
        String dia_atual_formatado = formatter.format(dia_atual);

        if (qtd_amarelo > 0) {
            throw new BusinessRuleException(
                    "Você está amarelado, então não pode realizar avaliação de outros jogadores");
        }
        System.out.println(dia_pelada.equals(dia_atual_formatado));
        if (!(dia_pelada.equals(dia_atual_formatado))) {
            throw new BusinessRuleException(
                    "Já passou o tempo permitido para ser realizado a avaliação do jogador");
        }

        return true;
    }

}
