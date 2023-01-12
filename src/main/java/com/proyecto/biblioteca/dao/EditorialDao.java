package com.proyecto.biblioteca.dao;

import com.proyecto.biblioteca.Entidades.Editorial;
import org.springframework.data.repository.CrudRepository;


public interface EditorialDao extends CrudRepository<Editorial, Long> {
    
}
