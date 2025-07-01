package com.granja.animal_farm_web.Dto;

import com.granja.animal_farm_web.Entity.Enums.estadoSaludAnimal;
import com.granja.animal_farm_web.Entity.Enums.sexoAnimal;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AnimalDto {
    private Integer animalId;

    @NotNull(message = "El estado de salud es obligatorio")
    private estadoSaludAnimal estadoSalud;

    @NotBlank(message = "El nombre del animal es obligatorio")
    private String nombreAnimal;

    @NotNull(message = "El sexo es obligatorio")
    private sexoAnimal sexo;

    @NotNull(message = "El peso es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El peso debe ser mayor que 0")
    private BigDecimal peso;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;

    private LocalDateTime fechaActualizacion;

    private String fotoAnimal;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    private boolean estadoGestante;

    private boolean estado;

    private RazaDto raza;
}