package les.ifoot.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Service;

import les.ifoot.model.Campo;
import les.ifoot.model.CampoHorario;
import les.ifoot.model.Espaco;
import les.ifoot.model.Jogador;
import les.ifoot.model.Advertencia;
import les.ifoot.model.Avaliacao;
import les.ifoot.model.Horario;
import les.ifoot.model.Penalidade;
import les.ifoot.model.ReservaIndividual;
import les.ifoot.model.Pelada;
import les.ifoot.model.ReservaGrupo;
import les.ifoot.model.Posicao;
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.model.TransferenciaDinheiroEspaco;

import les.ifoot.model.enums.DiadaSemana;

import les.ifoot.repositories.CampoHorarioRepository;
import les.ifoot.repositories.AdvertenciaRepository;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.repositories.EspacoRepository;
import les.ifoot.repositories.HorarioRepository;
import les.ifoot.repositories.JogadorRepository;
import les.ifoot.repositories.PenalidadeRepository;
import les.ifoot.repositories.ReservaIndividualRepository;
import les.ifoot.repositories.PeladaRepository;
import les.ifoot.repositories.ReservaGrupoRepository;
import les.ifoot.repositories.CampoRepository;
import les.ifoot.repositories.PosicaoRepository;
import les.ifoot.repositories.TransferirDinheiroRepository;
import les.ifoot.repositories.TransferenciaDinheiroEspacoRepository;

@Service
public class _DBService {
        @Autowired
        private JogadorRepository jogadorRepository;

        @Autowired
        private EspacoRepository espacoRepository;

        @Autowired
        private PenalidadeRepository penalidadeRepository;

        @Autowired
        private HorarioRepository horarioRepository;

        @Autowired
        private AvaliacaoRepository avaliacaoRepository;

        @Autowired
        private AdvertenciaRepository advertenciaRepository;

        @Autowired
        private ReservaIndividualRepository reservaIndividualRepository;

        @Autowired
        private PeladaRepository peladaRepository;

        @Autowired
        private CampoRepository campoRepository;

        @Autowired
        private ReservaGrupoRepository reservaGrupoRepository;

        @Autowired
        private PosicaoRepository posicaoRepository;

        @Autowired
        private TransferirDinheiroRepository transferirDinheiroRepository;

        @Autowired
        private TransferenciaDinheiroEspacoRepository transferenciaDineheiroEspacoRepository;

        // SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        // String dataFake = "19:00";
        // Date d = sdf.parse("19:00");
        // DateFormat formatador = new SimpleDateFormat("HH:mm");

        public void handleDataBaseTest() throws ParseException, IOException {
                // POSIÇÃO
                Posicao p1 = new Posicao(null, "Zagueiro", "ZG", "Rapido", "Muito Ruim");
                posicaoRepository.saveAll(Arrays.asList(p1));
                Posicao p2 = new Posicao(null, "Atacante", "ATA", "Forte", "Muito Bom");
                posicaoRepository.saveAll(Arrays.asList(p2));

<<<<<<< HEAD
                // JOGADOR
                Jogador jogador = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                                new Date(97, 7, 21),
                                "1234567", 0, "Alto Monte Cristo", new Float(35.00), p1);
                jogadorRepository.saveAll(Arrays.asList(jogador));

                Jogador jogador1 = new Jogador(null, "Vicenzo", "03814076050", "vivi.prince@hotmail.com",
                                new Date(99, 3, 11),
                                "1234567", 0, "Alto Monte Cristo", new Float(35.00), p2);
                jogadorRepository.saveAll(Arrays.asList(jogador1));

                // ESPACO
                Espaco espaco = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                                "1234567");
                espacoRepository.saveAll(Arrays.asList(espaco));
                Espaco espaco1 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                                "1234567");
                espacoRepository.saveAll(Arrays.asList(espaco1));

                // PENAIDADE
                Penalidade penalidade = new Penalidade(null, 1, 0, new Date(122, 4, 21),
                                jogador);
                penalidadeRepository.saveAll(Arrays.asList(penalidade));
                Penalidade penalidade1 = new Penalidade(null, 0, 1, new Date(122, 4, 28),
                                jogador1);
                penalidadeRepository.saveAll(Arrays.asList(penalidade1));

                // HORARIO
                // Horario horario = new Horario(null, formatador.parse("19:00"), 1);
                Horario horario = new Horario(null, "19:00", 1);
                // Horario horario = new Horario(null, new Date("19:00:00"), 1);
                horarioRepository.saveAll(Arrays.asList(horario));

                // AVALIACAO
                Avaliacao avaliacao = new Avaliacao(null, new Float(7.8), jogador);
                avaliacaoRepository.saveAll(Arrays.asList(avaliacao));

                // ADVERTENCIA
                Advertencia advertencia = new Advertencia(null, jogador);
                advertenciaRepository.saveAll(Arrays.asList(advertencia));

                // CAMPO
                Campo campo1 = new Campo(null, "Bom Gosto Society 1", new Float(80.00), new Float(280.00), espaco);
                campoRepository.saveAll(Arrays.asList(campo1));
                Campo campo2 = new Campo(null, "Hangar Society 1", new Float(85.00), new Float(290.00), espaco1);
                campoRepository.saveAll(Arrays.asList(campo2));

                CampoHorario campoHorario1 = new CampoHorario(campo1, horario);

                // RESERVA EM GRUPO
                ReservaGrupo reservaGrupo1 = new ReservaGrupo(campoHorario1);
                reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo1));
=======
                // // JOGADOR
                // Jogador jogador = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                //                 new Date(97, 7, 21),
                //                 "123", 0, "Alto Monte Cristo", new Float(35.00), p1);
                // jogadorRepository.saveAll(Arrays.asList(jogador));

                // Jogador jogador1 = new Jogador(null, "Vicenzo", "03814076050", "vivi.prince@hotmail.com",
                //                 new Date(99, 3, 11),
                //                 "123", 0, "Alto Monte Cristo", new Float(35.00), p2);
                // jogadorRepository.saveAll(Arrays.asList(jogador1));

                // // ESPACO
                // Espaco espaco = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                //                 "123");
                // espacoRepository.saveAll(Arrays.asList(espaco));
                // Espaco espaco1 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                //                 "123");
                // espacoRepository.saveAll(Arrays.asList(espaco1));

                // // PENAIDADE
                // Penalidade penalidade = new Penalidade(null, 1, 0, new Date(122, 4, 21), jogador);
                // penalidadeRepository.saveAll(Arrays.asList(penalidade));
                // Penalidade penalidade1 = new Penalidade(null, 0, 1, new Date(122, 4, 28), jogador1);
                // penalidadeRepository.saveAll(Arrays.asList(penalidade1));

                // // HORARIO
                // // Horario horario = new Horario(null, "19:00", DiadaSemana.toEnum(1));
                // // horarioRepository.saveAll(Arrays.asList(horario));

                // // AVALIACAO
                // Avaliacao avaliacao = new Avaliacao(null, new Float(7.8), jogador);
                // avaliacaoRepository.saveAll(Arrays.asList(avaliacao));

                // // ADVERTENCIA
                // Advertencia advertencia = new Advertencia(null, jogador);
                // advertenciaRepository.saveAll(Arrays.asList(advertencia));

                // // RESERVA EM GRUPO
                // ReservaGrupo reservaGrupo1 = new ReservaGrupo(null);
                // reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo1));
>>>>>>> 963f8ad4f03edf42c08a561d883def50b46db450
                // ReservaGrupo reservaGrupo2 = new ReservaGrupo(null);
                // reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo2));

                // PELADA
                Pelada pelada1 = new Pelada(null, new Date(122, 5, 10, 21, 00, 00));
                peladaRepository.saveAll(Arrays.asList(pelada1));
                Pelada pelada2 = new Pelada(null, new Date(122, 5, 17, 21, 00, 00));
                peladaRepository.saveAll(Arrays.asList(pelada2));

                // RESERVA INDIVIDUAL
                ReservaIndividual reservaIndividual1 = new ReservaIndividual(null, pelada1,
                                jogador);
                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual1));
                ReservaIndividual reservaIndividual2 = new ReservaIndividual(null, pelada2,
                                jogador1);
                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual2));

                // // TRANSFERENCIA DE DINHEIRO
                TransferirDinheiro td1 = new TransferirDinheiro(null, new Date(122, 05, 21),
                                new Float(250.00),
                                jogador1,
                                jogador);
                transferirDinheiroRepository.saveAll(Arrays.asList(td1));

                // // TRANSFERENCIA DE DINHEIRO
                TransferenciaDinheiroEspaco tde1 = new TransferenciaDinheiroEspaco(null, new Date(122, 05, 22),
                                new Float(350.00), jogador, espaco);
                transferenciaDineheiroEspacoRepository.saveAll(Arrays.asList(tde1));
        }
}
