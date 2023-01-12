
package com.proyecto.biblioteca.servicio;

import com.proyecto.biblioteca.Entidades.Usuario;
import com.proyecto.biblioteca.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  //Muy importante agregarlo
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true) //Solo cuando queramos leer la base de datos
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll(); //findAll() ==> Devuelve un Iterable
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override 
    @Transactional(readOnly = true)
    public Usuario buscarUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdusuarios()).orElse(null);
    }
    
}
