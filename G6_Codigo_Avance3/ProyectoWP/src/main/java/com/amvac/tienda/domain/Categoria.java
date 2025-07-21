/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Entity
@Data
@Table(name = "categoria")
/**
 *
 * @author arman
 */
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    
    private String nombre;
}
