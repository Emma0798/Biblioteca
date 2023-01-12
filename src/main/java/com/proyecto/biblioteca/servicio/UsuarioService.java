package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Usuario;
import java.util.List;


public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario buscarUsuario(Usuario usuario);
}
