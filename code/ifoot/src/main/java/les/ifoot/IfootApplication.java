package les.ifoot;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import les.ifoot.model.Advertencia;
import les.ifoot.model.Avaliacao;
import les.ifoot.model.Espaco;
import les.ifoot.model.Horario;
import les.ifoot.model.Jogador;
import les.ifoot.model.Penalidade;
import les.ifoot.model.enums.DiadaSemana;
import les.ifoot.repositories.AdvertenciaRepository;
import les.ifoot.repositories.AvaliacaoRepository;
import les.ifoot.repositories.EspacoRepository;
import les.ifoot.repositories.HorarioRepository;
import les.ifoot.repositories.JogadorRepository;
import les.ifoot.repositories.PenalidadeRepository;

@SpringBootApplication
public class IfootApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(IfootApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Jogador jogador = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com", new Date(97, 7, 21),
				"123", 0, "Alto Monte Cristo", new Float(35.00));
		jogadorRepository.saveAll(Arrays.asList(jogador));

		Espaco espaco = new Espaco(null, "Hangar", "84667172000103", "Linha Vermelha", "hangar@gmail.com", "123");
		espacoRepository.saveAll(Arrays.asList(espaco));

		Penalidade penalidade = new Penalidade(null, 1, 0, new Date(122, 4, 21));
		penalidadeRepository.saveAll(Arrays.asList(penalidade));

		Horario horario = new Horario(null, "19:00", DiadaSemana.toEnum(1));
		horarioRepository.saveAll(Arrays.asList(horario));

		Avaliacao avaliacao = new Avaliacao(null, new Float(7.8));
		avaliacaoRepository.saveAll(Arrays.asList(avaliacao));

		Advertencia advertencia = new Advertencia(null);
		advertenciaRepository.saveAll(Arrays.asList(advertencia));

	}

}
