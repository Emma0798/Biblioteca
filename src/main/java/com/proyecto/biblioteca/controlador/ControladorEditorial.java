package com.proyecto.biblioteca.controlador;

import com.proyecto.biblioteca.Entidades.Editorial;
import com.proyecto.biblioteca.servicio.EditorialService;
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
public class ControladorEditorial {
    
     @Autowired
    private EditorialService editorialService;
    
    @GetMapping("/editoriales")
    public String inicio(Model model){
        
        List<Editorial> editoriales= editorialService.listarEditoriales();  
                
        model.addAttribute("editoriales", editoriales);
        
        return "listaEditorial";
    }
    
    @GetMapping("/agregarEditorial")
    public String agregarAutor(Editorial editorial){  //Spring inyecta de forma automatica el objeto Usuario (no hace falta inicializarlo)
        
        return "modificarEditorial";
    }
    
    @PostMapping("/guardarEditorial")
    public String guardar(@Valid Editorial editorial, BindingResult errors){ //@Valid valida el objeto para que no sea null o empty
        
        if(errors.hasErrors()){  //Si hay errores en algun dato vuelve a la pagina de modificar
            return "modificarEditorial";
        }
        
        editorialService.guardar(editorial);
        
        return "redirect:/editoriales";  //Redirecciona a la pagina de inicio
    }
    
    @GetMapping("/editarEditorial/{idEditorial}") //El valor entre {} tiene que ser igual al nombre del atributo de la clase Usuario
    public String editar(Editorial editorial, Model model){
        editorial=editorialService.buscarEditorial(editorial);
        model.addAttribute("editorial",editorial);
        return "modificarEditorial";
    }
    
     @GetMapping("/eliminarEditorial")
    public String eliminar(Editorial editorial){
        editorialService.eliminar(editorial);
        return "redirect:/editoriales";
    }
}
