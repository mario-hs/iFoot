package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

//  import java.util.Collection;

//  import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// Olhar pois tem possibilidade de dar error, acho (Mario) que não precisa pois
	// tem o campo horario com as id de cada um
	// @JsonIgnore
	// @ManyToMany
	// @JoinTable(name = "campo_horario", joinColumns = @JoinColumn(name =
	// "campo_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
	// private Horario horario;

	@Column(length = 50)
	@NotBlank(message = "Nome do campo deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do campo deve ter entre 2 e 50 letras")
	private String nomeCampo;

	@Min(value = 1, message = "Valor unitário do campo deve ser maior que zero")
	@NotNull(message = "Valor unitário do campo deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor unitário do campo deve ser preenchido com dígitos")
	private Float valorUnit;

	@Min(value = 1, message = "Valor mensal do campo deve ser maior que zero")
	@NotNull(message = "Valor mensal do campo deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor mensal do campo deve ser preenchido com dígitos")
	private Float valorMes;

	@NotNull(message = "O espaço em campo deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

	// private Collection<Horario> campoHorario;

}
