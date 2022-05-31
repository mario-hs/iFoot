package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

// import les.ifoot.model.Espaco;
import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class TransferenciaDinheiroEspaco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A data em que a transferencia do espaço foi aplicada deve ser preenchida")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataTransferenciaEspaco;

	@Min(value = 1, message = "Valor da transferencia do espaço deve ser maior que zero")
	@NotNull(message = "Valor da transferencia do espaço deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor da transferencia do espaço deve ser preenchido com dígitos")
	private Float valor;

	@NotNull(message = "O jogador em transferencia de dinheiro espaço deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

	@NotNull(message = "O espaço em transferencia de dinheiro espaço deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

}
