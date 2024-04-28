package com.example.proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.proyecto.Service.AlumnoService;
import com.example.proyecto.Models.Alumno;
import java.util.List;
import java.util.stream.Collectors;

//import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerAlumno { 
   
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping ("/")
    public String index(){
        return "index";
    }

    @GetMapping ("/form")
    public String formularioAlumno(Model model){
        model.addAttribute("alumno", new Alumno());
        return "formularioAlumno";
}

@GetMapping("/date")
public String tabla (Model model){
    List<Alumno> listaAlumnos = alumnoService.obtenerTodosLosAlumnos();
    List<Alumno> alumnosConEstadoTrue = listaAlumnos.stream()
    .filter(alumno -> Boolean.TRUE.equals(alumno.getState()))
   .collect(Collectors.toList());
    model.addAttribute("listaAlumnos", alumnosConEstadoTrue);
    return "datoAlumnos";
}


@PostMapping("/guardarAlumno")
public String guardarAlumno(@ModelAttribute Alumno alumno) {
    alumnoService.guardarAlumno(alumno);
    return "redirect:/date";
}

@PostMapping ("/eliminarAlumno/{dni}")
public String eliminarAlumno (@PathVariable String dni) {
    Alumno alumno = alumnoService.buscarAlumnoConElDni(dni);
    if (alumno != null ){
        alumno.setState(false);
        alumnoService.guardarAlumno(alumno);
    }
    return "redirect:/guardarAlumno";
}

@PostMapping ("/editarAlumno/{dni}")
public String editarAlumno(@PathVariable String dni, Model model){
    Alumno alumno = alumnoService.buscarAlumnoConElDni(dni);
    if (alumno != null) {
    model.addAttribute("alumno", alumno);
return "actualizarAlumno";
} else {
    return "redirect:/date";
}
}
}