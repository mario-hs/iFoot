package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class ReservaIndividual implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A pelada em reserva individual deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "pelada_id")
	private Pelada pelada;

	@NotNull(message = "O jogador em reserva individual deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

}
