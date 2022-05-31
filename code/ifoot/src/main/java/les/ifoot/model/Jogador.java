package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(length = 50)
    @NotBlank(message = "O nome do jogador deve ser preenchido")
    @Size(min = 2, max = 50, message = "O nome do jogador deve ter entre 2 e 50 letras")
    private String nome;

    @Column(length = 11)
    @NotBlank(message = "O CPF do jogador deve ser preenchido")
    @Size(min = 11, max = 11, message = "O CPF do jogador deve ter 11 caracteres")
    private String cpf;

    @Column(length = 50)
    @NotBlank(message = "O E-mail do jogador deve ser preenchido")
    @Size(min = 2, max = 50, message = "O E-mail do jogador deve ter entre 2 e 50 letras")
    private String emailJogador;

    @NotNull(message = "A data de nascimento do jogador deve ser preenchida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(length = 15)
    @NotBlank(message = "A senha do jogador deve ser preenchida")
    @Size(min = 6, max = 15, message = "A senha do jogador deve ter entre 6 e 15 letras")
    private String senhaJogador;

    @Digits(integer = 1, fraction = 0, message = "A advertência do jogador deve ser preenchida com um valor inteiro")
    private Integer qtdAdvertencia;

    @Column(length = 50)
    @NotBlank(message = "Nome do bairro do jogador deve ser preenchido")
    @Size(min = 2, max = 50, message = "Nome do bairro do jogador deve ter entre 2 e 50 letras")
    private String bairro;

    @Min(value = 1, message = "Valor da carteira do jogador deve ser maior que zero")
    @NotNull(message = "Valor da carteira do jogador deve ser preenchido")
    @Digits(integer = 6, fraction = 2, message = "Valor da carteira do jogador deve ser preenchido com dígitos")
    private Float carteira;

    @NotNull(message = "A posição em jogador deve ser preenchida")
    @ManyToOne
    @JoinColumn(name = "posicao_id")
    private Posicao posicao;

}
