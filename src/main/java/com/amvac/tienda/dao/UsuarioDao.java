/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.amvac.tienda.dao;
import com.amvac.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author arman
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    // Método para buscar un usuario por su correo
    Usuario findByCorreo(String correo);
    Usuario findByCorreoAndPassword(String correo, String password);
}
