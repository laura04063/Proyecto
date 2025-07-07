/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.amvac.tienda.service;
import com.amvac.tienda.domain.Producto;
import java.util.List;
/**
 *
 * @author arman
 */
public interface ProductoService {

    List<Producto> getProductos(String categoria);
    Producto getProductoById(Long id);
}
