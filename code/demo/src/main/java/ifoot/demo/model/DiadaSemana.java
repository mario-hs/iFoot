package ifoot.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public enum DiadaSemana implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String SEGUNDA;

	private String TERCA;

	private String QUARTA;

	private String QUINTA;

	private String SEXTA;

	private String SABADO;

	private String DOMINGO;

}
