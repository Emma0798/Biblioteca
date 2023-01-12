package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Autor;
import com.proyecto.biblioteca.dao.AutorDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServiceImpl implements AutorService{

    @Autowired
    private AutorDao autorDao;
    
    
    
    @Override
    @Transactional(readOnly = true) //Solo cuando queramos leer la base de datos
    public List<Autor> listarAutores() {
        return (List<Autor>) autorDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Autor autor) {
        
        autorDao.save(autor);
    }

    @Override
    @Transactional
    public void eliminar(Autor autor) {
        autorDao.delete(autor);
    }

    @Override
    public Autor buscarAutor(Autor autor) {
        return autorDao.findById(autor.getIdAutor()).orElse(null);
    }
    
}
