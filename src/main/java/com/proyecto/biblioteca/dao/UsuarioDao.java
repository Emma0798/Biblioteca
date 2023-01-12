package com.proyecto.biblioteca.dao;

import com.proyecto.biblioteca.Entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Long>{  /*Implementa por default
    la clase*/
    
}
