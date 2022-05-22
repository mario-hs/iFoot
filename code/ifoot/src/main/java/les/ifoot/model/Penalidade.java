package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Penalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer qtdAmarelo;

	private Integer qtdVermelho;

	private Date dataPenalidade;

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

}
