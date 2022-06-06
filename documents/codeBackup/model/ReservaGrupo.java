package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

// @Entity
// @Data
// // @AllArgsConstructor
// @NoArgsConstructor
// @EqualsAndHashCode(of = { "id" })
// public class ReservaGrupo implements Serializable {

// private static final long serialVersionUID = 1L;

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Integer id;

// @JsonIgnore
// @Embedded
// private CampoHorarioPK id_CampoHorarioPK = new CampoHorarioPK();

// @Builder
// public ReservaGrupo(Campo campo, Horario horario) {
// this.id_CampoHorarioPK.setCampo(campo);
// this.id_CampoHorarioPK.setHorario(horario);
// }

// public Integer getHorarioId() {
// return id_CampoHorarioPK.getHorario().getId();
// }

// public Integer getCampoId() {
// return id_CampoHorarioPK.getCampo().getId();
// }

// public void setHorarioId(Integer id) {
// Horario horario = new Horario();
// horario.setId(id);
// this.id_CampoHorarioPK.setHorario(horario);
// }

// public void setCampoId(Integer id) {
// Campo campo = new Campo();
// campo.setId(id);
// this.id_CampoHorarioPK.setCampo(campo);
// }

// @NotNull(message = "A reserva deve ser preenchida")
// @ManyToOne
// @JoinColumn(name = "campo_horario_id")
// private CampoHorario campoHorario;

// @NotNull(message = "Jogador deve ser escolhido")
// @ManyToOne
// @JoinColumn(name = "jogador_id")
// private Jogador jogador;

// }

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