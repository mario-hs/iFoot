package ifoot.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class ReservaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// private Collection<Jogador> jogador;

	// Tem que mudar para CampoHorario sem PK
	@ManyToOne
	@JoinColumn(name = "campoHorario_id")
	private CampoHorarioPK campoHorario;

}
