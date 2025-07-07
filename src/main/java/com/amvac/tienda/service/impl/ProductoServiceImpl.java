/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.service.impl;
import com.amvac.tienda.dao.ProductoDao;
import com.amvac.tienda.domain.Producto;
import com.amvac.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author arman
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(String categoria) {
        if (categoria == null || categoria.isEmpty()) {
            return productoDao.findAll();
        }
        return switch (categoria.toLowerCase()) {
            case "novedades" -> productoDao.findByEsNovedad(true);
            case "promociones" -> productoDao.findByEsPromocion(true);
            case "recomendaciones" -> productoDao.findByEsRecomendacion(true);
            default -> productoDao.findByCategoriaNombre(categoria);
        };
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProductoById(Long id) {
        return productoDao.findById(id).orElse(null);
    }
}
