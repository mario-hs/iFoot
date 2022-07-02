package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class ReservaGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O Campo_Horario deve ser preenchida")
	@ManyToOne
	@JoinColumn(name = "campo_horario_id")
	private CampoHorario campoHorario;

	@NotNull(message = "Jogador deve ser escolhido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

}
