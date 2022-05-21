package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import les.ifoot.model.Espaco;
import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class TransferirDinheiroEspaco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

	private Integer id;

	private Date dataTransferenciaEspaco;

	private Integer valor;

	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

}
