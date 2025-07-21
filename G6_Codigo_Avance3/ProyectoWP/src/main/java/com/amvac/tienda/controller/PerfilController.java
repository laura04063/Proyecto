/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.controller;
import com.amvac.tienda.domain.Usuario;
import com.amvac.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
/**
 *
 * @author arman
 */
@Controller
public class PerfilController {
   @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public String verPerfil(Model model) {
        Usuario usuario = usuarioService.getUsuarioById(1L);
        
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }
        
        return "perfil";
    }

    @GetMapping("/perfil/editar")
    public String mostrarFormularioEditar(Model model) {
        Usuario usuario = usuarioService.getUsuarioById(1L);
        model.addAttribute("usuario", usuario);
        return "editar_perfil";
    }
    
    @PostMapping("/perfil/guardar")
    public String guardarCambiosPerfil(Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/perfil";
    }
}
