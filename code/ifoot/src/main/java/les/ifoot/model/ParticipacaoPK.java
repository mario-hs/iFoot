package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Data
@EqualsAndHashCode(of = { "pelada", "jogador" })

public class ParticipacaoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pelada_id")
	private Pelada pelada;

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;
}
