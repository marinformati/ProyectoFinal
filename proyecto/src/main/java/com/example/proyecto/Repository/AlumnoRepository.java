package com.example.proyecto.Repository;

import com.example.proyecto.Models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlumnoRepository extends JpaRepository <Alumno, String> {
    
}
