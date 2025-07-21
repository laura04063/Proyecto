/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.amvac.tienda.service;
import com.amvac.tienda.domain.Usuario;
/**
 *
 * @author arman
 */
public interface UsuarioService {
    
    Usuario getUsuarioByCorreo(String correo);
    void saveUsuario(Usuario usuario);
    Usuario validarUsuario(String correo, String password);
    Usuario getUsuarioById(Long id);
}
