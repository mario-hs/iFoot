package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ParticipacaoPK id = new ParticipacaoPK();

	@Builder
	public Participacao(Pelada pelada, Jogador jogador){
		this.id.setPelada(pelada);
		this.id.setJogador(jogador);
	}

	@JsonIgnore
	public Pelada getPelada() {
		return id.getPelada();
	}

	public Jogador getJogador() {
		return id.getJogador();
	}
	
}
