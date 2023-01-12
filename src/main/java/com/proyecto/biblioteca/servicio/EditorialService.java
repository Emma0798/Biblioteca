package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Editorial;
import java.util.List;

public interface EditorialService {
    
    public List<Editorial> listarEditoriales();

    public void guardar(Editorial editorial);

    public void eliminar(Editorial editorial);

    public Editorial buscarEditorial(Editorial editorial);
}
