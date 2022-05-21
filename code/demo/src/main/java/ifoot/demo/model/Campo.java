package ifoot.demo.model;

import java.util.Collection;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Campo extends ReservaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Campo-Horario",
	joinColumns = @JoinColumn(name = "Campo-id"), 
	inverseJoinColumns = @JoinColumn(name = "Horario-id")
	)
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "Espaco-id")
	private Espaco espaco;

	private String nomeCampo;

	private Float valorUnit;

	private Float valorMes;

	private Collection<Horario> campoHorario;

	

}
