package ifoot.demo.model;

import java.util.Date;

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
public class TransferirDinheiro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataTransferencia;

	private Integer valor;

	@ManyToOne
	@JoinColumn(name = "JogadorRemetente-id")
	private Jogador jogadorRemetente;

	@ManyToOne
	@JoinColumn(name = "JogadorDestinatario-id")
	private Jogador jogadorDestinatario;

}
