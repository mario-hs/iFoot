package les.ifoot.model;

// import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @EqualsAndHashCode(of = { "id" })
// @Entity
// public class Advertencia implements Serializable {

// private static final long serialVersionUID = 1L;

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Integer id;

// // @ManyToOne
// // @JoinColumn(name = "participacao_id")
// // private ParticipacaoPK participacao;

// @NotNull(message = "O jogador em advertencia deve ser preenchido")
// @ManyToOne
// @JoinColumn(name = "jogador_id")
// private Jogador jogador;

// // VER COM OS MENINOS SOBRE
// // @OneToOne
// // @JoinColumns({
// // @JoinColumn(name = "PARTICIPAO_ID", referencedColumnName =
// "PARTICIPAO_ID"),
// // @JoinColumn(name = "JOGADOR_ID", referencedColumnName = "JOGADOR_ID")
// // })
// // private Avaliacao avaliacao = new Avaliacao();

// }

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Advertencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private AdvertenciaPK id = new AdvertenciaPK();

	@Builder
	public Advertencia(Participacao participacao) {
		this.id.setParticipacao(participacao);
	}

	public Integer getJogadorId() {
		return id.getParticipacao().getJogador().getId();
	}

	public Integer getPeladaId() {
		return id.getParticipacao().getPelada().getId();
	}

	public void setJogadorId(Integer id) {
		Jogador jogador = new Jogador();
		jogador.setId(id);
		this.id.getParticipacao().setJogador(jogador);
	}

	public void setPeladaId(Integer id) {
		Pelada pelada = new Pelada();
		pelada.setId(id);
		this.id.getParticipacao().setPelada(pelada);
	}

}
