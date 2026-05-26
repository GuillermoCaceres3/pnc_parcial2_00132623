package org.example.parcial2ncapas00132623.Model.DTOs.Requests;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.parcial2ncapas00132623.Enums.Type;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagicProviderRequestDTO {
    @NotBlank(message="El proveedor debe llevar un nombre")
    private String name;

    @NotNull(message = "El proveedor debe llevar un tipo")
    private Type type;

    @NotNull(message="El producto debe llevar un precio")
    @DecimalMin(value= "0.01", message = "Los articulos no pueden ser gratuitos")
    private BigDecimal price;

    @NotNull(message="Debes indicar si el proveedor esta activo o no")
    private boolean isActive;
}
