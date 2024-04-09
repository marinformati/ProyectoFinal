package com.example.proyecto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControllerAlumno {
    @GetMapping ("/")
    public String index(){
        return "index";
    }

    @GetMapping ("/form")
    public String formularioAlumno(){
        return "formularioAlumno";
}
}
