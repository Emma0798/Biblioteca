package com.proyecto.biblioteca.controlador;

import com.proyecto.biblioteca.Entidades.Autor;
import com.proyecto.biblioteca.servicio.AutorService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorAutor {
    
    @Autowired
    private AutorService autorService;
    
    @GetMapping("/autores")
    public String inicio(Model model){
        
        List<Autor> autores= autorService.listarAutores();  
                
        model.addAttribute("autores", autores);
        
        return "listaAutores";
    }
    
    @GetMapping("/agregarAutor")
    public String agregarAutor(Autor autor){  //Spring inyecta de forma automatica el objeto Usuario (no hace falta inicializarlo)
        
        return "modificarAutor";
    }
    
    @PostMapping("/guardarAutor")
    public String guardar(@Valid Autor autor, BindingResult errors){ //@Valid valida el objeto para que no sea null o empty
        
        if(errors.hasErrors()){  //Si hay errores en algun dato vuelve a la pagina de modificar
            return "modificar";
        }
        
        autorService.guardar(autor);
        
        return "redirect:/autores";  //Redirecciona a la pagina de inicio
    }
    
    @GetMapping("/editarAutor/{idAutor}") //El valor entre {} tiene que ser igual al nombre del atributo de la clase Usuario
    public String editar(Autor autor, Model model){
        autor=autorService.buscarAutor(autor);
        model.addAttribute("autor",autor);
        return "modificarAutor";
    }
    
     @GetMapping("/eliminarAutor")
    public String eliminar(Autor autor){
        autorService.eliminar(autor);
        return "redirect:/autores";
    }
}
