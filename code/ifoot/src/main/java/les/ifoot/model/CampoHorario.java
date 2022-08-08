package les.ifoot.model;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class CampoHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O campo em Campo_Horario deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "campo_id")
	private Campo campo;

	@NotNull(message = "O horário em Campo_Horario deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;

	// @NotNull(message = "O horário em Campo_Horario deve ser preenchido")
	// @ManyToMany
	// @JoinTable(name = "CAMPOHORARIO_HORARIOS", joinColumns = @JoinColumn(name =
	// "campo_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
	// private Collection<Horario> horario = new ArrayList<>();

}
