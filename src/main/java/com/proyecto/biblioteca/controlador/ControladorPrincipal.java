package com.proyecto.biblioteca.controlador;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorPrincipal {
    @GetMapping("/")
    public String inicio(){

        return "index";
    }
}
