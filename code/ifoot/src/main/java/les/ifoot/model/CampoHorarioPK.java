package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;


@Embeddable
@Data
@EqualsAndHashCode(of = { "horario", "campo" })
public class CampoHorarioPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "horario-id")
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "campo-id")
	private Campo campo;
}
