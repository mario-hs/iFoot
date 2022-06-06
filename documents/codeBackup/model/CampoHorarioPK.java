package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Data
@EqualsAndHashCode(of = { "campo", "horario" })
public class CampoHorarioPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "campo_id")
	private Campo campo;

	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;
}
