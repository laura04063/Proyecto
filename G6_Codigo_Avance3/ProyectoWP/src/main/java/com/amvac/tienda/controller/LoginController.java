/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.controller;
import com.amvac.tienda.domain.Usuario;
import com.amvac.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author arman
 */
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    // Muestra la página de login
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    // Muestra la página de registro
    @GetMapping("/registro")
    public String showRegistro(Usuario usuario) {
        return "registro";
    }
    // Procesa el formulario de registro
    @PostMapping("/registrar")
    public String registrarUsuario(Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/login";
    }
    
    @PostMapping("/login")
    public String procesarLogin(@RequestParam("username") String correo, @RequestParam("password") String password) {
        
        Usuario usuario = usuarioService.validarUsuario(correo, password);
        
        if (usuario != null) {
            return "redirect:/";
        } else {
            return "redirect:/login?error=true";
        }
    }
}
