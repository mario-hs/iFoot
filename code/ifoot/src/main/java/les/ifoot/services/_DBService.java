package les.ifoot.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

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
        private TransferenciaJogadorRepository transferenciaJogadorRepository;

        @Autowired
        private TransferenciaEspacoRepository transferenciaEspacoRepository;

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
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                String data_atual[] = new String[1];
                data_atual = timeStamp.split(" ");

                // POSIÇÃO
                Posicao posicao_1 = new Posicao(null, "Zagueiro", "ZG", "Rapido", "Muito Ruim");
                Posicao posicao_2 = new Posicao(null, "Atacante", "ATA", "Forte", "Muito Bom");

                // JOGADOR
                Jogador jogador_1 = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                                date.parse("21/07/1997"), "1234567", "Alto Monte Cristo", 35.00, 0, 15, 1, posicao_1);
                Jogador jogador_2 = new Jogador(null, "Vicenzo", "23814076050", "vivi@hotmail.com",
                                date.parse("11/03/1998"), "1234567", "Maria Ortiz", 35.00, 0, 27, 5, posicao_2);
                Jogador jogador_3 = new Jogador(null, "Tony", "13814076070", "chopper@hotmail.com",
                                date.parse("18/11/1996"), "1234567", "Serrano", 55.00, 0, 9, 4, posicao_2);
                Jogador jogador_4 = new Jogador(null, "Patrick", "43814076090", "trick007@hotmail.com",
                                date.parse("02/07/1996"), "1234567", "Principal", 5.00, 1, 10, 7, posicao_1);

                // ESPACO
                Espaco espaco_1 = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                                "1234567", 300.00);
                Espaco espaco_2 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                                "1234567", 200.00);

                // HORARIO
                Horario horario_1 = new Horario(null, "19:00", 1, true, null);
                Horario horario_2 = new Horario(null, "20:00", 1, false, null);

                // CAMPO
                Campo campo_1 = new Campo(null, "A", 80.00, 280.00, 1500.00, 1, espaco_1);
                Campo campo_2 = new Campo(null, "B", 80.00, 280.00, 1500.00, 2, espaco_1);
                Campo campo_3 = new Campo(null, "C", 85.00, 290.00, 1450.00, 1, espaco_2);
                Campo campo_4 = new Campo(null, "D", 85.00, 290.00, 1450.00, 2, espaco_2);

                // CAMPO HORARIO
                CampoHorario campoHorario_1 = new CampoHorario(null, campo_1, horario_1);
                CampoHorario campoHorario_2 = new CampoHorario(null, campo_2, horario_2);

                // TRANSFERENCIA DE DINHEIRO ENTRE JOGADORES
                TransferenciaJogador transferencia_jogador_1 = new TransferenciaJogador(null, data_atual[0],
                                20.00, jogador_1, jogador_2);
                TransferenciaJogador transferencia_jogador_2 = new TransferenciaJogador(null, data_atual[0],
                                10.00, jogador_1, jogador_2);
                TransferenciaJogador transferencia_jogador_3 = new TransferenciaJogador(null, data_atual[0],
                                10.00, jogador_1, jogador_2);
                TransferenciaJogador transferencia_jogador_4 = new TransferenciaJogador(null, data_atual[0], 10.00,
                                jogador_3, jogador_4);
                TransferenciaJogador transferencia_jogador_5 = new TransferenciaJogador(null, data_atual[0], 10.00,
                                jogador_2, jogador_1);

                // TRANSFERENCIA DE DINHEIRO ENTRE JOGADOR E ESPACO
                TransferenciaEspaco transferencia_espaco_1 = new TransferenciaEspaco(null,
                                date.parse("26/06/2021"), 8.5, jogador_1, espaco_1);
                TransferenciaEspaco transferencia_espaco_2 = new TransferenciaEspaco(null,
                                date.parse("06/07/2022"), 8.5, jogador_2, espaco_1);
                TransferenciaEspaco transferencia_espaco_3 = new TransferenciaEspaco(null,
                                date.parse("11/07/2022"), 8.5, jogador_3, espaco_2);

                // RESERVA EM GRUPO
                ReservaGrupo reservaGrupo_1 = new ReservaGrupo(null, campoHorario_1,
                                Arrays.asList(jogador_1, jogador_2, jogador_3), 2);
                ReservaGrupo reservaGrupo_2 = new ReservaGrupo(null, campoHorario_2,
                                Arrays.asList(jogador_3, jogador_4), 1);

                // PELADA COM ROUPA
                // Pelada pelada_1 = new Pelada(null, "26/06/2021", reservaGrupo_1);
                // Pelada pelada_2 = new Pelada(null, "07/07/2022", reservaGrupo_2);
                Pelada pelada_1 = new Pelada(null, date.parse("26/07/2021"), reservaGrupo_1);
                Pelada pelada_2 = new Pelada(null, date.parse("07/06/2022"), reservaGrupo_1);
                Pelada pelada_3 = new Pelada(null, date.parse("11/07/2022"), reservaGrupo_2);
                // Pelada pelada_3 = new Pelada(null, data_atual[0], reservaGrupo_2);

                ReservaIndividual reservaIndividual_1 = new ReservaIndividual(null, pelada_1, jogador_4);

                // PARTICIPACAO DO JOGADOR
                Participacao participacao_1 = new Participacao(null, pelada_1, Arrays.asList(jogador_1, jogador_2));
                Participacao participacao_2 = new Participacao(null, pelada_2, Arrays.asList(jogador_2));
                Participacao participacao_3 = new Participacao(null, pelada_3, Arrays.asList(jogador_2));

                // PENALIDADE DO JOGADOR
                Penalidade penalidade_1 = new Penalidade(null, 1, 0, date.parse("21/06/2022"), jogador_1);
                Penalidade penalidade_2 = new Penalidade(null, 0, 1, date.parse("26/06/2022"), jogador_4);

                // AVALIACAO DO JOGADOR
                Avaliacao avaliacao_1 = new Avaliacao(null, 7.8, jogador_1, jogador_2, participacao_1);
                Avaliacao avaliacao_2 = new Avaliacao(null, 4.8, jogador_2, jogador_3, participacao_2);
                Avaliacao avaliacao_3 = new Avaliacao(null, 5.8, jogador_3, jogador_4, participacao_2);
                Avaliacao avaliacao_4 = new Avaliacao(null, 6.8, jogador_4, jogador_1, participacao_2);

                // ADVERTENCIA DO JOGADOR
                Advertencia advertencia_1 = new Advertencia(null, participacao_1, jogador_3);

                // SALVANDO NO BANCO DE DADOS
                posicaoRepository.saveAll(Arrays.asList(posicao_1, posicao_2));

                jogadorRepository.saveAll(Arrays.asList(jogador_1, jogador_2, jogador_3, jogador_4));

                espacoRepository.saveAll(Arrays.asList(espaco_1, espaco_2));

                horarioRepository.saveAll(Arrays.asList(horario_1, horario_2));

                campoRepository.saveAll(Arrays.asList(campo_1, campo_2, campo_3, campo_4));

                campoHorarioRepository.saveAll(Arrays.asList(campoHorario_1, campoHorario_2));

                transferenciaJogadorRepository.saveAll(Arrays.asList(transferencia_jogador_1, transferencia_jogador_2,
                                transferencia_jogador_3, transferencia_jogador_4, transferencia_jogador_5));

                transferenciaEspacoRepository.saveAll(
                                Arrays.asList(transferencia_espaco_1, transferencia_espaco_2, transferencia_espaco_3));

                penalidadeRepository.saveAll(Arrays.asList(penalidade_1, penalidade_2));

                reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo_1, reservaGrupo_2));

                peladaRepository.saveAll(Arrays.asList(pelada_1, pelada_2, pelada_3));

                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual_1));

                participacaoRepository.saveAll(Arrays.asList(participacao_1, participacao_2, participacao_3));

                avaliacaoRepository.saveAll(Arrays.asList(avaliacao_1, avaliacao_2, avaliacao_3, avaliacao_4));

                advertenciaRepository.saveAll(Arrays.asList(advertencia_1));

        }
}