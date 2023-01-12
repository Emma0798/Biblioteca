package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Editorial;
import com.proyecto.biblioteca.dao.EditorialDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialDao editorialDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
       return (List<Editorial>) editorialDao.findAll();
    }

    @Override
    public void guardar(Editorial editorial) {
        editorialDao.save(editorial);
    }

    @Override
    public void eliminar(Editorial editorial) {
        editorialDao.delete(editorial);
    }

    @Override
    public Editorial buscarEditorial(Editorial editorial) {
        
        return editorialDao.findById(editorial.getIdEditorial()).orElse(null);
        
    }
    
}
