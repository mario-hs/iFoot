package ifoot.demo.model;

import java.util.Date;
import java.util.Collection;

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
public class Pelada implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataPelada;

	// private Collection<Jogador> participacao;

	@ManyToOne
	@JoinColumn(name = "ReservaGrupo-id")
	private ReservaGrupo reservaGrupo;

}
