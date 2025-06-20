package com.granja.animal_farm_web.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
@Table(name= "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String tipoDocumento;
    private String numeroIdentificacion;
    private String generoUsuario;
    private LocalDate fechaDeIngreso;
    private LocalDate fechaDeNacimiento;
    private Integer edad;
    private String numeroDeTelefono;
    private String correo;
    private String fotoDelTrabajador;
    private boolean estado = true; // Nuevo campo para activar/desactivar usuario


    public Usuario() {
    }
}