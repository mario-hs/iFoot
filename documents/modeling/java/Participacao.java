package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "pelada", "jogador" })
@Entity

public class ParticipacaoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pelada_id")
	private Pelada pelada;

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;
}
