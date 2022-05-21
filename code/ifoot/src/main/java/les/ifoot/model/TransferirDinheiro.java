package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class TransferirDinheiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataTransferencia;

	private Integer valor;

	@ManyToOne
	@JoinColumn(name = "jogadorRemetente_id")
	private Jogador jogadorRemetente;

	@ManyToOne
	@JoinColumn(name = "jogadorDestinatario_id")
	private Jogador jogadorDestinatario;

}
