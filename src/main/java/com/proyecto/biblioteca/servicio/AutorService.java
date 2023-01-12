package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Autor;
import java.util.List;

public interface AutorService {

    public List<Autor> listarAutores();

    public void guardar(Autor autor);

    public void eliminar(Autor autor);

    public Autor buscarAutor(Autor autor);
}
