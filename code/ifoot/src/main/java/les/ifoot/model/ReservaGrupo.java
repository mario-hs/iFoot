package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@EmbeddedId
	private ReservaGrupoPK id = new ReservaGrupoPK();

	@Builder
	public ReservaGrupo(CampoHorario campoHorario) {
		this.id.setCampoHorario(campoHorario);
	}

	public Integer getHorarioId() {
		return id.getCampoHorario().getHorario().getId();
	}

	public Integer getCampoId() {
		return id.getCampoHorario().getCampo().getId();
	}

	public void setHorarioId(Integer id) {
		Horario horario = new Horario();
		horario.setId(id);
		this.id.getCampoHorario().setHorario(horario);
	}

	public void setCampoId(Integer id) {
		Campo campo = new Campo();
		campo.setId(id);
		this.id.getCampoHorario().setCampo(campo);
	}
}
