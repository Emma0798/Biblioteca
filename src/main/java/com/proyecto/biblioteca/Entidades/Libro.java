package com.proyecto.biblioteca.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="libros")
public class Libro implements Serializable{
    
    private static final long serialVersionUID = 1L; //Implementa la interfaz de serializable
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    
    private Long ISBN;
    
    private String nombre;
    
    private Integer anioDePublicacion;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Editorial editorial;
}
