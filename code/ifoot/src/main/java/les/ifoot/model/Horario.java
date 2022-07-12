package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

import les.ifoot.model.enums.DiadaSemana;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O horário que o campo foi reservado deve ser preenchido")
	private String hora;
	@Min(value = 0, message = "Escolha um dia da semana existente")
	@Max(value = 6, message = "Escolha um dia da semana existente")
	private Integer diaSemana;

	@Builder
	public Horario(Integer id, String hora, DiadaSemana diaSemana) {
		this.id = id;
		this.diaSemana = diaSemana.getCod();
		this.hora = hora;
	}

	public DiadaSemana getdiaSemana() {
		return DiadaSemana.toEnum(diaSemana);
	}

	public void setdiaSemana(DiadaSemana diaSemana) {
		this.diaSemana = diaSemana.getCod();
	}

	@NotNull(message = "O atributo 'disponivel' do Horário deve ser preenchido")
	@NotNull(message = "O Horário do Campo deve ser preenchido")
	private Boolean status;

	private String descricao;
}
