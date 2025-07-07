/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.controller;
import com.amvac.tienda.domain.Producto;
import com.amvac.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author arman
 */
@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto/{idProducto}")
    public String verProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        
        Producto producto = productoService.getProductoById(idProducto);

        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto_detalle";
        }
        
        return "redirect:/catalogo";
    }
}
