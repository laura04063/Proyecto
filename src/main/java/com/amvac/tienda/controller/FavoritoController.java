/**
 *
 * @author Joselito
 */
package com.amvac.tienda.controller;

import com.amvac.tienda.dao.FavoritoDao;
import com.amvac.tienda.dao.ProductoDao;
import com.amvac.tienda.dao.UsuarioDao;
import com.amvac.tienda.domain.Favorito;
import com.amvac.tienda.domain.Producto;
import com.amvac.tienda.domain.Usuario;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoDao favoritoDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ProductoDao productoDao;

    @PostMapping("/toggle")
    @Transactional
    public ResponseEntity<String> toggleFavorito(
            @RequestParam Long idUsuario,
            @RequestParam Long idProducto) {

        Usuario usuario = usuarioDao.findById(idUsuario).orElse(null);
        Producto producto = productoDao.findById(idProducto).orElse(null);

        if (usuario == null || producto == null) {
            return ResponseEntity.badRequest().body("Usuario o producto no encontrados");
        }

        Optional<Favorito> existente = favoritoDao.findByUsuarioAndProducto(usuario, producto);

        if (existente.isPresent()) {
            favoritoDao.eliminar(existente.get());
            return ResponseEntity.ok("Se elimino de favoritos");
        } else {
            Favorito nuevo = new Favorito();
            nuevo.setUsuario(usuario);
            nuevo.setProducto(producto);
            favoritoDao.guardar(nuevo);
            return ResponseEntity.ok("Se agrego a favoritos");
        }
    }
    @GetMapping("/existe")
public ResponseEntity<Boolean> existeFavorito(
        @RequestParam Long idUsuario,
        @RequestParam Long idProducto) {

    Usuario usuario = usuarioDao.findById(idUsuario).orElse(null);
    Producto producto = productoDao.findById(idProducto).orElse(null);

    if (usuario == null || producto == null) {
        return ResponseEntity.ok(false);
    }

    boolean existe = favoritoDao.findByUsuarioAndProducto(usuario, producto).isPresent();
    return ResponseEntity.ok(existe);
}
}
