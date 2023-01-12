
package com.proyecto.biblioteca.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data  //Genera automaticamente los getters y setters de la clase
@Entity
@Table(name = "usuarios") //Hay que poner el nombre de la tabla como esta en la base de datos
public class Usuario implements Serializable { //@Table se utiliza para que no haya errores a la hora de correr el programa en distintos sistemas operativos
    
    private static final long serialVersionUID = 1L; //Implementa la interfaz de serializable
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuarios;
    
    @NotEmpty (message="Nombre incorrecto")
    private String nombre;
    
    @NotEmpty (message="Apellido incorrecto")
    private String apellido;
    
    @NotEmpty (message="Email incorrecto")
    private String email;
    
    @NotEmpty (message="Contraseña incorrecta")
    private String password;

}
