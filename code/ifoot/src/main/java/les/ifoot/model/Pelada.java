package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Pelada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A data da pelada deve ser preenchida")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPelada;

	@NotNull(message = "A reservaGrupo em pelada deve ser preenchida")
	@ManyToOne
	@JoinColumn(name = "reservaGrupo_id")
	private ReservaGrupo reservaGrupo;
}
