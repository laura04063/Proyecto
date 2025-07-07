/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.controller;
import com.amvac.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author arman
 */
@Controller
public class CatalogoController {

    @Autowired
    private ProductoService productoService;

    // Muestra la página del catálogo
    @GetMapping("/catalogo")
    public String showCatalogo(Model model, @RequestParam(name = "categoria", required = false) String categoria) {
        var productos = productoService.getProductos(categoria);
        model.addAttribute("productos", productos);
        model.addAttribute("pageTitle", categoria != null ? categoria : "Catálogo");
        return "catalogo";
    }
    
}
