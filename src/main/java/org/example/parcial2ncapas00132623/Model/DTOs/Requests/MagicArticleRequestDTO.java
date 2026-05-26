package org.example.parcial2ncapas00132623.Model.DTOs.Requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.parcial2ncapas00132623.Enums.Type;
import org.example.parcial2ncapas00132623.Model.MagicProvider;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagicArticleRequestDTO {
    @NotBlank(message = "Se debe asignar un nombre al articulo")
    private String name;

    @NotNull(message="Se debe asignar un tipo al articulo")
    private Type type;

    @NotNull(message="el articulo debe tener un proveedor")
    private MagicProvider provider;
}
