package com.granja.animal_farm_web.Entity;
import com.granja.animal_farm_web.Entity.Enums.generoUsuario;
import com.granja.animal_farm_web.Entity.Enums.tipoDocumento;
import jakarta.persistence.*;
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

    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;


    @Enumerated(EnumType.STRING)
    @Column(name = "genero_usuario")
    private generoUsuario generoUsuario;

    @Column(name = "fecha_de_ingreso")
    private LocalDate fechaDeIngreso;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "numero_de_telefono")
    private String numeroDeTelefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "foto_del_trabajador")
    private String fotoDelTrabajador;

    @Column(name = "estado")
    private boolean estado = true;

    @ManyToMany(mappedBy = "usuarios")
    private Set<HistoriaClinica> historiasClinicas = new HashSet<>();

}
