package com.proyecto.biblioteca.controlador;

import com.proyecto.biblioteca.Entidades.Usuario;
import com.proyecto.biblioteca.servicio.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private UsuarioService usuarioService;  //Instanciamos la clase UsuarioService ya que la implementacion la hace sola por el override
    
    @GetMapping("/usuarios")
    public String inicio(Model model){
        
        List<Usuario> usuarios = usuarioService.listarUsuarios();  
        
        
        model.addAttribute("usuarios", usuarios);
        
        return "listaUsuarios";
    }
    
    
    @GetMapping("/agregar")
    public String agregarUsuario(Usuario usuario){  //Spring inyecta de forma automatica el objeto Usuario (no hace falta inicializarlo)
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult errors){ //@Valid valida el objeto para que no sea null o empty
        
        if(errors.hasErrors()){  //Si hay errores en algun dato vuelve a la pagina de modificar
            return "modificar";
        }
        
        usuarioService.guardar(usuario);
        
        return "redirect:/listaUsuarios";  //Redirecciona a la pagina de inicio
    }
    
    @GetMapping("/editar/{idusuarios}") //El valor entre {} tiene que ser igual al nombre del atributo de la clase Usuario
    public String editar(Usuario usuario, Model model){
        usuario=usuarioService.buscarUsuario(usuario);
        model.addAttribute("usuario",usuario);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Usuario usuario){
        usuarioService.eliminar(usuario);
        return "redirect:/listaUsuarios";
    }
    
    
}
