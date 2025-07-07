/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
@Entity
@Data
@Table(name = "producto")
/**
 *
 * @author arman
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    
    @Column(length = 1000)
    private String descripcion;

    private String rutaImagen;
    private double precio;
    private boolean esNovedad;
    private boolean esPromocion;
    private boolean esRecomendacion;

    private String marca;
    private String tipo;
    private String formulacion;
    private String ingredienteActivo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
