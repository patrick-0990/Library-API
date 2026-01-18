package com.patrick0990.library_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutorDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter de 2 a 100 caracteres")
    private String nome;

    @NotBlank(message = "A nacionalidade é obrigatória")
    @Size(min = 2, max = 50, message = "A nacionalidade deve ter de 2 a 50 caracteres")
    private String nacionalidade;


}
