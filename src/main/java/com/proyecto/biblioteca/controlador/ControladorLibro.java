
package com.proyecto.biblioteca.controlador;

import com.proyecto.biblioteca.Entidades.Autor;
import com.proyecto.biblioteca.Entidades.Editorial;
import com.proyecto.biblioteca.Entidades.Libro;
import com.proyecto.biblioteca.servicio.AutorService;
import com.proyecto.biblioteca.servicio.EditorialService;
import com.proyecto.biblioteca.servicio.LibroService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorLibro {
    
    @Autowired
    private LibroService libroService;
    
    @Autowired
    private EditorialService editorialService;
    
    @Autowired
    private AutorService autorService;
    
    
    @GetMapping("/libros")
    public String inicio(Model model,@Param("palabraClave")String palabraClave){
       
        List<Libro> libros= libroService.listarLibros(palabraClave);  
                
        model.addAttribute("libros", libros);
        model.addAttribute("palabraClave",palabraClave);
        
        return "listaLibros";
    }
    
    
     @GetMapping("/agregarLibro")
    public String agregarAutor(Model modelo,Libro libro){  //Spring inyecta de forma automatica el objeto Usuario (no hace falta inicializarlo)
        
        List<Autor> autores =autorService.listarAutores();
        
        List<Editorial> editoriales = editorialService.listarEditoriales();
        
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        
        return "modificarLibro";
    }
    
    @PostMapping("/guardarLibro")
    public String guardar(@Valid Libro libro,Long idAutor,Long idEditorial, BindingResult errors){ //@Valid valida el objeto para que no sea null o empty
        
        if(errors.hasErrors()){  //Si hay errores en algun dato vuelve a la pagina de modificar
            return "modificarLibro";
        }
        
        libroService.guardar(libro,idAutor,idEditorial);
        
        return "redirect:/libros";  //Redirecciona a la pagina de inicio
    }
    
     @GetMapping("/editarLibro/{idLibro}") //El valor entre {} tiene que ser igual al nombre del atributo de la clase Usuario
    public String editar(Libro libro, Model model,Long idAutor,Long idEditorial){
                
        List<Autor> autores =autorService.listarAutores();
        
        List<Editorial> editoriales = editorialService.listarEditoriales();
        
        model.addAttribute("autores", autores);
        model.addAttribute("editoriales", editoriales);
        
        libro=libroService.buscarLibro(libro);
        model.addAttribute("libro",libro);
        return "modificarLibro";
    }
    
     @GetMapping("/eliminarLibro")
      public String eliminar(Libro libro){
        libroService.eliminar(libro);
        return "redirect:/libros";
    }
}
