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

        public void handleDataBaseTest() throws ParseException, IOException {
                SimpleDateFormat dateHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                // SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                // String dataFake = "19:00";
                // Date d = sdf.parse("19:00");
                // DateFormat formatador = new SimpleDateFormat("HH:mm");

                // POSIÇÃO
                Posicao p1 = new Posicao(null, "Zagueiro", "ZG", "Rapido", "Muito Ruim");
                Posicao p2 = new Posicao(null, "Atacante", "ATA", "Forte", "Muito Bom");

                // JOGADOR
                // Jogador jogador = new Jogador(null, "Mario", "03714076050",
                // "mr.prince@hotmail.com", new Date(97, 7, 21), "1234567", 0, "Alto Monte
                // Cristo", new Float(35.00), p1);
                // Jogador jogador1 = new Jogador(null, "Vicenzo", "03814076050",
                // "vivi.prince@hotmail.com", new Date(99, 3, 11), "1234567", 0, "Alto Monte
                // Cristo", new Float(35.00), p2);
                Jogador jogador = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                                date.parse("21/07/1997"), "1234567", 0, "Alto Monte Cristo", 35.00, p1);
                Jogador jogador1 = new Jogador(null, "Vicenzo", "03814076050", "vivi@hotmail.com",
                                date.parse("11/03/1998"), "1234567", 0, "Maria Ortiz", 35.00, p2);

                // ESPACO
                Espaco espaco = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                                "1234567");
                Espaco espaco1 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                                "1234567");

                // PENAIDADE
                Penalidade penalidade = new Penalidade(null, 1, 0, date.parse("21/06/2022"), jogador);
                Penalidade penalidade1 = new Penalidade(null, 0, 1, date.parse("26/06/2022"), jogador1);

                // AVALIACAO
                Avaliacao avaliacao = new Avaliacao(null, 7.8, jogador);

                // ADVERTENCIA
                Advertencia advertencia = new Advertencia(null, jogador);

                // HORARIO
                Horario horario = new Horario(null, "19:00", 1);
                // Horario horario = new Horario(null, "19:00", 1);
                // Horario horario = new Horario(null, new Date("19:00:00"), 1);

                // CAMPO
                Campo campo1 = new Campo(null, "Bom Gosto Society 1", 80.00, 280.00, espaco);
                Campo campo2 = new Campo(null, "Hangar Society 1", 85.00, 290.00, espaco1);

                CampoHorario campoHorario = new CampoHorario(campo1, horario);

                // RESERVA EM GRUPO - [ ERROR ]
                ReservaGrupo reservaGrupo1 = new ReservaGrupo(campoHorario);
                // ReservaGrupo reservaGrupo2 = new ReservaGrupo(null);
                // reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo2));

                // PELADA
                Pelada pelada1 = new Pelada(null, dateHora.parse("21/10/2022 19:00"));
                Pelada pelada2 = new Pelada(null, dateHora.parse("11/10/2022 21:00"));

                // RESERVA INDIVIDUAL
                ReservaIndividual reservaIndividual1 = new ReservaIndividual(null, pelada1, jogador);
                ReservaIndividual reservaIndividual2 = new ReservaIndividual(null, pelada2, jogador1);

                // // TRANSFERENCIA DE DINHEIRO
                TransferirDinheiro td1 = new TransferirDinheiro(null, date.parse("22/06/2022"), 250.00, jogador1,
                                jogador);

                // // TRANSFERENCIA DE DINHEIRO
                TransferenciaDinheiroEspaco tde1 = new TransferenciaDinheiroEspaco(null, date.parse("22/06/2022"),
                                350.00, jogador, espaco);

                posicaoRepository.saveAll(Arrays.asList(p2));
                posicaoRepository.saveAll(Arrays.asList(p1));

                jogadorRepository.saveAll(Arrays.asList(jogador));
                jogadorRepository.saveAll(Arrays.asList(jogador1));

                espacoRepository.saveAll(Arrays.asList(espaco));
                espacoRepository.saveAll(Arrays.asList(espaco1));

                penalidadeRepository.saveAll(Arrays.asList(penalidade));
                penalidadeRepository.saveAll(Arrays.asList(penalidade1));

                avaliacaoRepository.saveAll(Arrays.asList(avaliacao));

                advertenciaRepository.saveAll(Arrays.asList(advertencia));

                horarioRepository.saveAll(Arrays.asList(horario));

                campoRepository.saveAll(Arrays.asList(campo1));
                campoRepository.saveAll(Arrays.asList(campo2));

                peladaRepository.saveAll(Arrays.asList(pelada1));
                peladaRepository.saveAll(Arrays.asList(pelada2));

                reservaGrupoRepository.saveAll(Arrays.asList(reservaGrupo1));

                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual1));
                reservaIndividualRepository.saveAll(Arrays.asList(reservaIndividual2));

                transferirDinheiroRepository.saveAll(Arrays.asList(td1));
                transferenciaDineheiroEspacoRepository.saveAll(Arrays.asList(tde1));

        }
}
