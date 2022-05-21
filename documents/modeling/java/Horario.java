package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

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
	private String hora;

	private DiadaSemana diaSemana;

	private Integer id;

}
