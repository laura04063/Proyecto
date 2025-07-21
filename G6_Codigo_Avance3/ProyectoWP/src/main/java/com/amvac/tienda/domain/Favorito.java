/**
 *
 * @author Joselito
 */
package com.amvac.tienda.domain;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorito", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_usuario", "id_producto"})
})
@Data
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFavorito;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
