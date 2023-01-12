package com.proyecto.biblioteca.dao;

import com.proyecto.biblioteca.Entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LibroDao extends CrudRepository<Libro, Long> {
    
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre);
    
    @Query("SELECT l FROM Libro l WHERE l.nombre LIKE %?1%"
            + "OR l.autor.nombre LIKE %?1%"
            + "OR l.editorial.nombre LIKE %?1%")
    public List<Libro> findFiltro(String palabraClave);
    
}
