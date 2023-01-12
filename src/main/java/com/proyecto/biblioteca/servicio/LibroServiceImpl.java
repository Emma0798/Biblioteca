package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Autor;
import com.proyecto.biblioteca.Entidades.Editorial;
import com.proyecto.biblioteca.Entidades.Libro;
import com.proyecto.biblioteca.dao.AutorDao;
import com.proyecto.biblioteca.dao.EditorialDao;
import com.proyecto.biblioteca.dao.LibroDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroDao libroDao;
    
    @Autowired
    private AutorDao autorDao;
    
    @Autowired
    private EditorialDao editorialDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros(String palabraClave) {
        
        if(palabraClave != null){
            return libroDao.findFiltro(palabraClave);
        }
        
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Libro libro,Long idAutor,Long idEditorial) {
        
        Autor autor = autorDao.findById(idAutor).get();
        
        Editorial editorial = editorialDao.findById(idEditorial).get();
        
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro buscarLibro(Libro libro) {
        
        return libroDao.findById(libro.getIdLibro()).orElse(null);
    }
    
    
}
