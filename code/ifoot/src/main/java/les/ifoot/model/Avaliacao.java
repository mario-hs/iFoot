package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Min(value = 1, message = "Valor da nota da avaliação deve ser maior que zero")
	@NotNull(message = "Valor da nota da avaliação deve ser preenchido")
	@Digits(integer = 2, fraction = 1, message = "Valor da nota da avaliação deve ser preenchido com dígitos")
	private Float nota;

	// @ManyToOne
	// @JoinColumn(name = "participacao_id")
	// private ParticipacaoPK participacao;

	@NotNull(message = "O jogador em avaliação deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

	// VER COM OS MENINOS SOBRE
	// @OneToOne
	// @JoinColumns({
	// @JoinColumn(name = "PARTICIPAO_ID", referencedColumnName = "PARTICIPAO_ID"),
	// @JoinColumn(name = "JOGADOR_ID", referencedColumnName = "JOGADOR_ID")
	// })
	// private Avaliacao avaliacao = new Avaliacao();

}
