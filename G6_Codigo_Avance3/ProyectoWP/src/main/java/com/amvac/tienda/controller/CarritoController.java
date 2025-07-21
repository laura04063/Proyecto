package com.amvac.tienda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class CarritoController {
    @GetMapping("/Carrito")
    public String mostrarCarrito(Model model) {
            model.addAttribute("currentPage", "Carrito");
        return "Carrito";
    }
}

