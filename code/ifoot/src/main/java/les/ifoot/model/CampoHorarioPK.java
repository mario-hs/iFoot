package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

<<<<<<< HEAD
@Embeddable
@Data
@EqualsAndHashCode(of = { "horario", "campo" })

=======

@Embeddable
@Data
@EqualsAndHashCode(of = { "horario", "campo" })
>>>>>>> 963f8ad4f03edf42c08a561d883def50b46db450
public class CampoHorarioPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "campo_id")
	private Campo campo;
}
