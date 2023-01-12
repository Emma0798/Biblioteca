package com.proyecto.biblioteca.dao;

import com.proyecto.biblioteca.Entidades.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorDao extends CrudRepository<Autor,Long>{
    
}
