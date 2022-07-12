package les.ifoot.model;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import les.ifoot.model.enums.TipoReserva;

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

	@NotNull(message = "A reserva grupo deve possuir pelo menos um 10 jogadores")
	@ManyToMany
	@JoinTable(name = "RESERVA_GRUPO_JOGADOR", joinColumns = @JoinColumn(name = "reserva_grupo_id"), inverseJoinColumns = @JoinColumn(name = "jogador_id"))
	private Collection<Jogador> jogador = new ArrayList<>();

	@NotNull(message = "Deve ser preenchido o periodo da reserva em grupo.")
	private Integer tipoReserva;

	@Builder
	public ReservaGrupo(Integer id, CampoHorario campoHorario, TipoReserva tipoReserva) {
		this.id = id;
		this.campoHorario = campoHorario;
		this.tipoReserva = tipoReserva.getCod();
	}

	public TipoReserva getTipoReserva() {
		return TipoReserva.toEnum(tipoReserva);
	}

	public void setTioReserva(TipoReserva tipoReserva) {
		this.tipoReserva = tipoReserva.getCod();
	}
}
