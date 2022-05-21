package ifoot.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class TransferirDinheiroEspaco implements Serializable{
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@ManyToOne
	@JoinColumn(name = "Jogador-id")
	private Jogador jogador;

	private Integer id;

	private Date dataTransferenciaEspaco;

	private Integer valor;

	@ManyToOne
	@JoinColumn(name = "Espaco-id")
	private Espaco espaco;

}
