package com.granja.animal_farm_web.Entity;

import java.time.LocalDate;


public class Usuario {

    private int usuarioId;
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


    public Usuario() {
    }
}