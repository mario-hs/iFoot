package les.ifoot.model;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A pelada em participação deve ser preenchida")
	@ManyToOne
	@JoinColumn(name = "pelada_id")
	private Pelada pelada;

	// @NotNull(message = "O jogador em participação deve ser preenchido")
	// @ManyToOne
	// @JoinColumn(name = "jogador_id")
	// private Jogador jogador;

	@NotNull(message = "Participação deve possuir ao menos um 10 jogadores")
	@ManyToMany
	@JoinTable(name = "PARTICIPACAO_LISTA_JOGADOR", joinColumns = @JoinColumn(name = "participacao_id"), inverseJoinColumns = @JoinColumn(name = "jogador_id"))
	private Collection<Jogador> jogador = new ArrayList<>();
}
