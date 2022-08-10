package les.ifoot.model;

import java.io.Serializable;

import javax.validation.constraints.*;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Posicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 15)
	@NotBlank(message = "O nome da posição deve ser preenchido")
	@Size(min = 6, max = 15, message = "O nome da posição entre 6 e 15 letras")
	private String nomePosicao;

	@Column(length = 3)
	@NotBlank(message = "A sigla em posição deve ser preenchida")
	@Size(min = 2, max = 3, message = "A sigla em posição deve ter entre 2 e 3 letras")
	private String sigla;

	@Column(length = 150)
	@NotBlank(message = "A caracteristica da posição deve ser preenchida")
	@Size(min = 5, max = 150, message = "A caracteristica da posição deve ter entre 4 e 30 letras")
	private String caracteristica;

	@Column(length = 250)
	@Size(min = 0, max = 250, message = "A descricao da posição deve ter entre 0 e 150 letras")
	private String descricao;

}
