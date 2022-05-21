package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "horario", "campo" })
@Entity

public class CampoHorarioPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn
	private Horario horario;

	@ManyToOne
	@JoinColumn
	private Campo campo;
}
