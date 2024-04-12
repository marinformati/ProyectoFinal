package com.example.proyecto.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
public class Alumno {

    @Id
    private Integer dni;
    @Column (name = "state")
    private Boolean state;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private Integer telefono;
    @Column
    private LocalDate fechaNacimiento;
    
    public Integer getDni(){
        return dni;
    }
    public void setDni(Integer dni){
        this.dni = dni;
    }
    public boolean getState(){
        return state;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public Integer getTelefono(){
        return telefono;
    }
    public void setNombre(Integer telefono){
        this.telefono = telefono;
    }
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNAcimiento){
        this.fechaNacimiento = fechaNAcimiento;
    }
}
