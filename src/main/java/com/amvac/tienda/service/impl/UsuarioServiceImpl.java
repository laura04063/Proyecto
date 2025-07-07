/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.amvac.tienda.service.impl;
import com.amvac.tienda.dao.UsuarioDao;
import com.amvac.tienda.domain.Usuario;
import com.amvac.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;;
/**
 *
 * @author arman
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    @Transactional
    public void saveUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario validarUsuario(String correo, String password) {
        return usuarioDao.findByCorreoAndPassword(correo, password);
    }
}
