package les.ifoot.model;

import java.util.Collection;
import java.util.ArrayList;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import les.ifoot.model.enums.TipoCampo;
import lombok.*;

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

	@Column(length = 50)
	@NotBlank(message = "Nome do campo deve ser preenchido")
	@Size(min = 1, max = 50, message = "Nome do campo deve ter entre 2 e 50 letras")
	private String nomeCampo;

	@Min(value = 1, message = "Valor unitário do campo deve ser maior que zero")
	@NotNull(message = "Valor unitário do campo deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor unitário do campo deve ser preenchido com dígitos")
	private Double valorUnit;

	@Min(value = 1, message = "Valor mensal do campo deve ser maior que zero")
	@NotNull(message = "Valor mensal do campo deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor mensal do campo deve ser preenchido com dígitos")
	private Double valorMes;

	@Min(value = 1, message = "Valor anual do campo deve ser maior que zero")
	@NotNull(message = "Valor anual do campo deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor anual do campo deve ser preenchido com dígitos")
	private Double valorAno;

	@NotNull(message = "O tipo do campo deve ser preenchido!")
	private Integer tipoCampo;

	@NotNull(message = "O espaço em campo deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

	@Builder
	public Campo(Integer id, String nomeCampo, TipoCampo tipoCampo) {
		this.id = id;
		this.nomeCampo = nomeCampo;
		this.espaco = espaco;
		this.valorUnit = valorUnit;
		this.valorMes = valorMes;
		this.valorAno = valorAno;
		this.tipoCampo = tipoCampo.getCod();
	}

	public TipoCampo gettipoCampo() {
		return TipoCampo.toEnum(tipoCampo);
	}

	public void settipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo.getCod();
	}

	// @NotNull(message = "O horário em Campo_Horario deve ser preenchido")
	// @ManyToMany
	// @JoinTable(name = "CAMPO_HORARIO", joinColumns = @JoinColumn(name =
	// "campo_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
	// private Collection<Horario> horario = new ArrayList<>();
}
