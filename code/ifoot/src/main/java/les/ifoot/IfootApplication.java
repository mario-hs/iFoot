package les.ifoot;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import les.ifoot.model.Jogador;
import les.ifoot.repositories.JogadorRepository;

@SpringBootApplication
public class IfootApplication implements CommandLineRunner {

	@Autowired
	private JogadorRepository jogadorRepository;

	public static void main(String[] args) {
		SpringApplication.run(IfootApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Jogador j1 = new Jogador(null, "Mario", "03714076050", "mr.prince@hotmail.com", new Date(1997, 8, 21), "123", 0,
				"Alto Monte Cristo");
		// Jogador j2 = new Jogador(null, "Qual sua opinião sobre o Wix?", false, false,
		// u5);
		jogadorRepository.saveAll(Arrays.asList(j1));
	}

}
