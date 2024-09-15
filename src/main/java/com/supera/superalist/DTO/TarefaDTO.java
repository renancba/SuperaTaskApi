package com.supera.superalist.DTO;

import com.supera.superalist.Enum.TarefaStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TarefaDTO {

    private Long id;

    @NotBlank(message = "Nome inválido.")
    private String nome;

    @Size(max = 300)
    private String descricao;

    @FutureOrPresent
    private Date data;

    private TarefaStatus status;
}
