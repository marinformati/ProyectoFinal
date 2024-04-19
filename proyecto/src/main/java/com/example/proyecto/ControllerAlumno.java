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
    model.addAttribute("listaAlumnos", listaAlumnos);
    return "datoAlumnos";
}


@PostMapping("/guardarAlumno")
public String guardarAlumno(@ModelAttribute Alumno alumno) {
    alumnoService.guardarAlumno(alumno);
    return "redirect:/";
}


}
