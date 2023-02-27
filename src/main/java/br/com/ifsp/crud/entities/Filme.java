package br.com.ifsp.crud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotBlank
    @NotNull
    private String titulo;
    @NotBlank
    @NotNull
    private String genero;
    @NotBlank
    @NotNull
    private String diretor;
    @NotBlank
    @NotNull
    private String duracao;


}
