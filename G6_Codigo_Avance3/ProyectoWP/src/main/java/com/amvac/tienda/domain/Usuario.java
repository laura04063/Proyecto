/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@Table(name = "usuario")
/**
 *
 * @author arman
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;
    
    private String nombre;
    private String nombreEmpresa;
    private String ubicacion;
    private String telefono;
    
   @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "favorito",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private Set<Producto> favoritos = new HashSet<>();
}
