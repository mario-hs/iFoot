package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class CampoHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private CampoHorarioPK id = new CampoHorarioPK();

	@Builder
	public CampoHorario(Campo campo, Horario horario) {
		this.id.setCampo(campo);
		this.id.setHorario(horario);
	}

	@JsonIgnore
	public Campo getCampo() {
		return id.getCampo();
	}

	public void setCampo(Campo campo) {
		id.setCampo(campo);
	}

	public Horario getHorario() {
		return id.getHorario();
	}

	public void setHorario(Horario horario) {
		id.setHorario(horario);
	}

}
