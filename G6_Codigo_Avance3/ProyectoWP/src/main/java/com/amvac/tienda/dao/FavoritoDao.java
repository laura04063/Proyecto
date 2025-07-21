/**
 *
 * @author Joselito
 */
package com.amvac.tienda.dao;

import com.amvac.tienda.domain.Favorito;
import com.amvac.tienda.domain.Producto;
import com.amvac.tienda.domain.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FavoritoDao {

    @PersistenceContext
    private EntityManager em;

    public Optional<Favorito> findByUsuarioAndProducto(Usuario usuario, Producto producto) {
        try {
            Favorito favorito = em.createQuery(
                "SELECT f FROM Favorito f WHERE f.usuario = :usuario AND f.producto = :producto", Favorito.class)
                .setParameter("usuario", usuario)
                .setParameter("producto", producto)
                .getSingleResult();
            return Optional.of(favorito);
        } catch (Exception e) {
            return Optional.empty(); // no existe
        }
    }

    @Transactional
    public void guardar(Favorito favorito) {
        em.persist(favorito);
    }

    @Transactional
    public void eliminar(Favorito favorito) {
        em.remove(em.contains(favorito) ? favorito : em.merge(favorito));
    }
}
