/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.amvac.tienda.dao;
import com.amvac.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author arman
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {
    // Métodos para filtrar por las categorías especiales
    List<Producto> findByEsNovedad(boolean esNovedad);
    List<Producto> findByEsPromocion(boolean esPromocion);
    List<Producto> findByEsRecomendacion(boolean esRecomendacion);
    
    // Método para filtrar por el nombre de la categoría
    List<Producto> findByCategoriaNombre(String nombreCategoria);
}
