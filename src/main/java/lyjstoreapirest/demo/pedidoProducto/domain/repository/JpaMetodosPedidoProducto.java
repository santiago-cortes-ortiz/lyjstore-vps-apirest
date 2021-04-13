package lyjstoreapirest.demo.pedidoProducto.domain.repository;

import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosPedidoProducto extends JpaRepository<PedidoProducto,Long> {
}
