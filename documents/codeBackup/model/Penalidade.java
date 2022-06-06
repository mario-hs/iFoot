package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Penalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Digits(integer = 1, fraction = 0, message = "A quantidade de amarelos deve ser preenchida com um valor inteiro")
	private Integer qtdAmarelo;

	@Digits(integer = 1, fraction = 0, message = "A a quantidade de vermelhos deve ser preenchida com um valor inteiro")
	private Integer qtdVermelho;

	@NotNull(message = "A data em que a penalidade foi aplicada deve ser preenchida")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPenalidade;


	@NotNull(message = "O jogador em penalidade deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

}
