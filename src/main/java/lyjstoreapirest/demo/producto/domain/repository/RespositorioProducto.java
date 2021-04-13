package lyjstoreapirest.demo.producto.domain.repository;

import lyjstoreapirest.demo.producto.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RespositorioProducto  {

    Long guardar(Producto producto);

    Optional<Producto> buscarProductoPorId(Long idProducto);

    Optional<Producto> eliminarProductoPorId(Long idProducto);

    List<Producto> listarProductos();
}
