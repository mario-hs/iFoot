package les.ifoot.model;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Advertencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A participação em advertencia deve ser preenchida")
	@ManyToOne
	@JoinColumn(name = "participacao_id")
	private Participacao participacao;

	@NotNull(message = "O jogador em advertencia deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;
}
