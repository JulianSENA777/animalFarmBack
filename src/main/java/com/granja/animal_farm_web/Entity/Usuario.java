package com.granja.animal_farm_web.Entity;
import com.granja.animal_farm_web.Entity.Enums.generoUsuario;
import com.granja.animal_farm_web.Entity.Enums.tipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
@Table(name= "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento_usuario")
    private tipoDocumento tipoDocumento;

    @NotBlank(message = "El número de identificación es obligatorio")
    @Column(name = "numero_identificacion", unique = true)
    private String numeroIdentificacion;


    @Enumerated(EnumType.STRING)
    @Column(name = "genero_usuario")
    private generoUsuario generoUsuario;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @Column(name = "fecha_de_ingreso")
    private LocalDate fechaDeIngreso;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Column(name = "edad")
    private Integer edad;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "^\\d{7,15}$", message = "El número de teléfono debe contener solo números y tener entre 7 y 15 dígitos")
    @Column(name = "numero_de_telefono")
    private String numeroDeTelefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Column(name = "correo")
    private String correo;

    @Column(name = "foto_del_trabajador")
    private String fotoDelTrabajador;

    @Column(name = "estado")
    private boolean estado = true;

}
