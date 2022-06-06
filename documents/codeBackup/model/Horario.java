package les.ifoot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
// import javax.swing.plaf.DimensionUIResource;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	// @Column(length = 4)
	// @NotBlank(message = "Nome do espaço deve ser preenchido")
	// @Size(min = 4, max = 4, message = "Nome do espaço deve ter entre 2 e 50
	// letras")
	// private String espaco;

	// @DateTimeFormat(style = "HH:mm")
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@NotNull(message = "O horário que o campo foi reservado deve ser preenchido")
	private String hora;

	@Digits(integer = 1, fraction = 0, message = "Dia da semana nao foi especificado")
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

}
