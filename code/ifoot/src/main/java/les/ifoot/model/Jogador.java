package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private String emailJogador;

    private Date dataNascimento;

    private String senhaJogador;

    private Integer qtdAdvertencia;

    private String bairro;

    private Float carteira;

    @ManyToOne
    @JoinColumn(name = "posicao_id")
    private Posicao posicao;

}
