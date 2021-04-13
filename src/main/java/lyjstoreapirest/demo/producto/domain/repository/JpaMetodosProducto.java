package lyjstoreapirest.demo.producto.domain.repository;

import lyjstoreapirest.demo.producto.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosProducto extends JpaRepository<Producto, Long> {
}
