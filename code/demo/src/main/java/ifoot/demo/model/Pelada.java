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

public class Pelada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataPelada;

	// private Collection<Jogador> participacao;

	@ManyToOne
	@JoinColumn(name = "reservaGrupo_id")
	private ReservaGrupo reservaGrupo;

}
