package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "pelada_id")
	private Pelada pelada;

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;
}
