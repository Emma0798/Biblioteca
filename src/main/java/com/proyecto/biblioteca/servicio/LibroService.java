package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Libro;
import java.util.List;

public interface LibroService {
    
    public List<Libro> listarLibros(String palabraClave);

    public void guardar(Libro libro,Long idAutor,Long idEditorial);

    public void eliminar(Libro libro);

    public Libro buscarLibro(Libro libro);
   
}
