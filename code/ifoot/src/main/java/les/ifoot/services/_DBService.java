package les.ifoot.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les.ifoot.model.*;

import les.ifoot.repositories.*;

@Service
public class _DBService {
        @Autowired
        private JogadorRepository jogadorRepository;

        @Autowired
        private EspacoRepository espacoRepository;

        @Autowired
        private HorarioRepository horarioRepository;

        @Autowired
        private CampoRepository campoRepository;

        @Autowired
        private PosicaoRepository posicaoRepository;

        @Autowired
        private CampoHorarioRepository campoHorarioRepository;

        @Autowired
        private TransferirDinheiroRepository transferirDinheiroRepository;

        @Autowired
        private ReservaGrupoRepository reservaGrupoRepository;

        @Autowired
        private ReservaIndividualRepository reservaIndividualRepository;

        @Autowired
        private PeladaRepository peladaRepository;

        @Autowired
        private PenalidadeRepository penalidadeRepository;

        @Autowired
        private AvaliacaoRepository avaliacaoRepository;

        @Autowired
        private ParticipacaoRepository participacaoRepository;

        @Autowired
        private AdvertenciaRepository advertenciaRepository;

        public void handleDataBaseTest() throws ParseException, IOException {
                // SimpleDateFormat dateHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

                // POSIÇÃO
                Posicao posicao_1 = new Posicao(null, "Zagueiro", "ZG", "Rapido", "Muito Ruim");
                Posicao posicao_2 = new Posicao(null, "Atacante", "ATA", "Forte", "Muito Bom");

                // JOGADOR
                Jogador jogador_1 = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                                date.parse("21/07/1997"), "1234567", 0, "Alto Monte Cristo", 35.00, posicao_1);
                Jogador jogador_2 = new Jogador(null, "Vicenzo", "23814076050", "vivi@hotmail.com",
                                date.parse("11/03/1998"), "1234567", 0, "Maria Ortiz", 35.00, posicao_2);
                Jogador jogador_3 = new Jogador(null, "Tony", "13814076070", "chopper@hotmail.com",
                                date.parse("18/11/1996"), "1234567", 0, "Serrano", 55.00, posicao_2);

                // ESPACO
                Espaco espaco_1 = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                                "1234567");
                Espaco espaco_2 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                                "1234567");

                // HORARIO
                Horario horario_1 = new Horario(null, "19:00", 1, true, null);
                Horario horario_2 = new Horario(null, "20:00", 1, false, null);

                // CAMPO
                Campo campo_1 = new Campo(null, "Society A", 80.00, 280.00, 1500.00, espaco_1);
                Campo campo_2 = new Campo(null, "Futsal A", 80.00, 280.00, 1500.00, espaco_1);
                Campo campo_3 = new Campo(null, "Society A", 85.00, 290.00, 1450.00, espaco_2);
                Campo campo_4 = new Campo(null, "Campo A", 85.00, 290.00, 1450.00, espaco_2);

                // CAMPO HORARIO
                CampoHorario campoHorario_1 = new CampoHorario(null, campo_1, horario_1);

                // TRANSFERENCIA DE DINHEIRO ENTRE JOGADORES
                TransferirDinheiro transferencia_jogador_1 = new TransferirDinheiro(null, ("22/06/2022"),
                                30.00, jogador_1, jogador_2);
                // TransferirDinheiro transferencia_jogador_2 = new TransferirDinheiro(null,
                // date.parse("24/06/2022"),
                TransferirDinheiro transferencia_jogador_2 = new TransferirDinheiro(null, ("22/06/2022"),
                                20.00, jogador_2, jogador_1);
                TransferirDinheiro transferencia_jogador_3 = new TransferirDinheiro(null, ("24/06/2022"),
                                20.00, jogador_2, jogador_1);
                TransferirDinheiro transferencia_jogador_4 = new TransferirDinheiro(null, ("03/07/2022"),
                                20.00, jogador_2, jogador_1);
                TransferirDinheiro transferencia_jogador_5 = new TransferirDinheiro(null, ("02/07/2022"),
                                20.00, jogador_2, jogador_1);
                TransferirDinheiro transferencia_jogador_6 = new TransferirDinheiro(null, ("02/07/2022"),
                                20.00, jogador_2, jogador_1);

                // RESERVA EM GRUPO
                ReservaGrupo reservaGrupo_1 = new ReservaGrupo(null, campoHorario_1,
                                Arrays.asList(jogador_2, jogador_3));

                // PELADA COM ROUPA
                Pelada pelada_1 = new Pelada(null, date.parse("21/06/2022"), reservaGrupo_1);
                Pelada pelada_2 = new Pelada(null, date.parse("24/06/2022"), reservaGrupo_1);

                ReservaIndividual reservaIndividual_1 = new ReservaIndividual(null, pelada_1, jogador_1);

                // PARTICIPACAO DO JOGADOR
                Participacao participacao_1 = new Participacao(null, pelada_1, jogador_2);
                Participacao participacao_2 = new Participacao(null, pelada_2, jogador_1);

                // PENALIDADE DO JOGADOR
                Penalidade penalidade_1 = new Penalidade(null, 1, 0, date.parse("21/06/2022"), jogador_1);
                Penalidade penalidade_2 = new Penalidade(null, 0, 1, date.parse("26/06/2022"), jogador_2);

                // AVALIACAO DO JOGADOR
                Avaliacao avaliacao_1 = new Avaliacao(null, 7.8, jogador_1, jogador_2, participacao_1);
                Avaliacao avaliacao_2 = new Avaliacao(null, 6.8, jogador_2, jogador_3, participacao_2);

                // ADVERTENCIA DO JOGADOR
                Advertencia advertencia_1 = new Advertencia(null, participacao_1, jogador_3);

                // SALVANDO NO BANCO DE DADOS
                posicaoRepository.saveAll(Arrays.asList(posicao_1, posicao_2));

                jogadorRepository.saveAll(Arrays.asList(jogador_1, jogador_2, jogador_3));

                espacoRepository.saveAll(Arrays.asList(espaco_1, espaco_2));

                horarioRepository.saveAll(Arrays.asList(horario_1, horario_2));

                campoRepository.saveAll(Arrays.asList(campo_1, campo_2, campo_3, campo_4));

                campoHorarioRepository.saveAll(Arrays.asList(campoHorario_1));

                transferirDinheiroRepository.saveAll(Arrays.asList(transferencia_jogador_1, transferencia_jogador_2,
                                transferencia_jogador_3, transferencia_jogador_4, transferencia_jogador_5,
                                transferencia_jogador_6));

                reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo_1));

                penalidadeRepository.saveAll(Arrays.asList(penalidade_1, penalidade_2));

                peladaRepository.saveAll(Arrays.asList(pelada_1, pelada_2));

                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual_1));

                participacaoRepository.saveAll(Arrays.asList(participacao_1, participacao_2));

                avaliacaoRepository.saveAll(Arrays.asList(avaliacao_1, avaliacao_2));

                advertenciaRepository.saveAll(Arrays.asList(advertencia_1));

        }
}