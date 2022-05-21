package ifoot.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Campo extends ReservaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// Olhar pois tem possibilidade de dar error, acho (Mario) que não precisa pois
	// tem o campo horario com as id de cada um
	// @JsonIgnore
	// @ManyToMany
	// @JoinTable(name = "campo_horario", joinColumns = @JoinColumn(name =
	// "campo_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
	// private Horario horario;

	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

	private String nomeCampo;

	private Float valorUnit;

	private Float valorMes;

	private Collection<Horario> campoHorario;

}
