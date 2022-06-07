package les.ifoot.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les.ifoot.model.Campo;
// import les.ifoot.model.CampoHorario;
import les.ifoot.model.Espaco;
import les.ifoot.model.Jogador;
import les.ifoot.model.Horario;
import les.ifoot.model.Posicao;

import les.ifoot.repositories.EspacoRepository;
import les.ifoot.repositories.HorarioRepository;
import les.ifoot.repositories.JogadorRepository;
// import les.ifoot.repositories.CampoHorarioRepository;
import les.ifoot.repositories.CampoRepository;
import les.ifoot.repositories.PosicaoRepository;

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

        // @Autowired
        // private CampoHorarioRepository campoHorarioRepository;

        public void handleDataBaseTest() throws ParseException, IOException {
                // SimpleDateFormat dateHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

                // POSIÇÃO
                Posicao posicao_1 = new Posicao(null, "Zagueiro", "ZG", "Rapido", "Muito Ruim");
                Posicao posicao_2 = new Posicao(null, "Atacante", "ATA", "Forte", "Muito Bom");

                // JOGADOR
                Jogador jogador_1 = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com",
                                date.parse("21/07/1997"), "1234567", 0, "Alto Monte Cristo", 35.00, posicao_1);
                Jogador jogador_2 = new Jogador(null, "Vicenzo", "03814076050", "vivi@hotmail.com",
                                date.parse("11/03/1998"), "1234567", 0, "Maria Ortiz", 35.00, posicao_2);

                // ESPACO
                Espaco espaco_1 = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com",
                                "1234567");
                Espaco espaco_2 = new Espaco(null, "Bom Gosto", "94767172000103", "Linha Amarela", "bomgosto@gmail.com",
                                "1234567");

                // HORARIO
                Horario horario_1 = new Horario(null, "19:00", 1, true, null);
                Horario horario_2 = new Horario(null, "20:00", 1, false, null);

                // CAMPO
                Campo campo_1 = new Campo(null, "Bom Gosto Society 1", 80.00, 280.00, 1500.00, espaco_1);
                Campo campo_2 = new Campo(null, "Hangar Society 1", 85.00, 290.00, 1450.00, espaco_2);

                // CampoHorario campoHorario_1 = new CampoHorario(campo_1, horario_1);

                posicaoRepository.saveAll(Arrays.asList(posicao_1));
                posicaoRepository.saveAll(Arrays.asList(posicao_2));

                jogadorRepository.saveAll(Arrays.asList(jogador_1));
                jogadorRepository.saveAll(Arrays.asList(jogador_2));

                espacoRepository.saveAll(Arrays.asList(espaco_1));
                espacoRepository.saveAll(Arrays.asList(espaco_2));

                horarioRepository.saveAll(Arrays.asList(horario_1));
                horarioRepository.saveAll(Arrays.asList(horario_2));
                // campoHorarioRepository.saveAll(Arrays.asList(campoHorario_1));

                campoRepository.saveAll(Arrays.asList(campo_1));
                campoRepository.saveAll(Arrays.asList(campo_2));

        }
}
