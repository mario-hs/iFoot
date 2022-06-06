package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*; 

@Embeddable
@Data
@EqualsAndHashCode(of = {"participacao"})
public class AvaliacaoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "PELADA_ID", referencedColumnName = "PELADA_ID"),
        @JoinColumn(name = "JOGADOR_ID", referencedColumnName = "JOGADOR_ID")
    })
    private Participacao participacao = new Participacao();

}