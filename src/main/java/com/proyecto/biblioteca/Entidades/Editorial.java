package com.proyecto.biblioteca.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "editoriales")
public class Editorial implements Serializable{
    
    private static final long serialVersionUID = 1L; //Implementa la interfaz de serializable
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;
    @NotEmpty (message="Nombre incorrecto")
    private String nombre;
 
    private Integer anioDeAlta;
    
}
