package lyjstoreapirest.demo.producto.application;

import lyjstoreapirest.demo.producto.domain.model.Producto;
import lyjstoreapirest.demo.rol.domain.model.Rol;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    Long guardar(Producto producto);

    Optional<Producto> buscarProductoPorId(Long idProducto);

    Optional<Producto> eliminarProductoPorId(Long idProducto);

    List<Producto> listarProductos();
}
