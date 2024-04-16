package com.example.proyecto.Service;

import com.example.proyecto.Models.Alumno;
import com.example.proyecto.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository AlumnoRepository;

    public void guardarAlumno(Alumno alumno) {
        AlumnoRepository.save(alumno);
    }

    
}