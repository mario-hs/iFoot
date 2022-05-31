package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Espaco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome do espaço deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do espaço deve ter entre 2 e 50 letras")
	private String nomeEspaco;

	@Column(length = 14)
	@NotBlank(message = "o CNPJ em espaço deve ser preenchido")
	@Size(min = 14, max = 14, message = "O CNPJ em espaço deve ter 14 caracteres")
	private String cnpj;

	@Column(length = 50)
	@NotBlank(message = "Nome do bairro em espaço deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do bairro em espaço deve ter entre 2 e 50 letras")
	private String bairro;

	@Column(length = 50)
	@NotBlank(message = "O E-mail do espaço deve ser preenchido")
	@Size(min = 2, max = 50, message = "O E-mail do espaço deve ter entre 2 e 50 letras")
	private String emailEspaco;

	@Column(length = 15)
	@NotBlank(message = "A senha do espaço deve ser preenchida")
	@Size(min = 6, max = 15, message = "A senha do espaço deve ter entre 6 e 15 letras")
	private String senhaEspaco;

}
