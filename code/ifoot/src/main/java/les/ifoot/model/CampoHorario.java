package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class CampoHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "campo_id")
	private Campo campo;

	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;

}
