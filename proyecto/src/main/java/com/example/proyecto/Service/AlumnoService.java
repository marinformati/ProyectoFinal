package com.example.proyecto.Service;

import com.example.proyecto.Models.Alumno;
import com.example.proyecto.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository AlumnoRepository;


    public void guardarAlumno(Alumno alumno) {
        AlumnoRepository.save(alumno);
    }

    public List<Alumno> obtenerTodosLosAlumnos(){
        return AlumnoRepository.findAll();
    }

    public Alumno buscarAlumnoConElDni (String dni) {
        Optional <Alumno> optionalAlumno = AlumnoRepository.findById(dni);
        return optionalAlumno.orElse(null);
    }
}