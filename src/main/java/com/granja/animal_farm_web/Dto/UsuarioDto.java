package com.granja.animal_farm_web.Dto;

import com.granja.animal_farm_web.Entity.Enums.tipoDocumento;
import com.granja.animal_farm_web.Entity.Enums.generoUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto {
    private Integer usuarioId; // Integer para permitir null y evitar enviar 0
    private String nombreUsuario;
    private String apellidoUsuario;
    private tipoDocumento tipoDocumento;
    private String numeroIdentificacion;
    private generoUsuario generoUsuario;
    private LocalDate fechaDeIngreso;
    private LocalDate fechaDeNacimiento;
    private Integer edad;
    private String numeroDeTelefono;
    private String correo;
    private String fotoDelTrabajador;
    private boolean estado;

    // Getters y setters
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getApellidoUsuario() { return apellidoUsuario; }
    public void setApellidoUsuario(String apellidoUsuario) { this.apellidoUsuario = apellidoUsuario; }
    public tipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(tipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }
    public generoUsuario getGeneroUsuario() { return generoUsuario; }
    public void setGeneroUsuario(generoUsuario generoUsuario) { this.generoUsuario = generoUsuario; }
    public LocalDate getFechaDeIngreso() { return fechaDeIngreso; }
    public void setFechaDeIngreso(LocalDate fechaDeIngreso) { this.fechaDeIngreso = fechaDeIngreso; }
    public LocalDate getFechaDeNacimiento() { return fechaDeNacimiento; }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) { this.fechaDeNacimiento = fechaDeNacimiento; }
    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }
    public String getNumeroDeTelefono() { return numeroDeTelefono; }
    public void setNumeroDeTelefono(String numeroDeTelefono) { this.numeroDeTelefono = numeroDeTelefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getFotoDelTrabajador() { return fotoDelTrabajador; }
    public void setFotoDelTrabajador(String fotoDelTrabajador) { this.fotoDelTrabajador = fotoDelTrabajador; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
