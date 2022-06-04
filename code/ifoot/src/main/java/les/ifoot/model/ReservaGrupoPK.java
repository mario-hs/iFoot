package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

// import les.ifoot.model.CampoHorario;

import lombok.*;

// import java.util.*;

@Embeddable
@Data
@EqualsAndHashCode(of = { "campoHorario" })
public class ReservaGrupoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "HORARIO_ID", referencedColumnName = "HORARIO_ID"),
			@JoinColumn(name = "CAMPO_ID", referencedColumnName = "CAMPO_ID")
	})

	private CampoHorario campoHorario = new CampoHorario();

}
