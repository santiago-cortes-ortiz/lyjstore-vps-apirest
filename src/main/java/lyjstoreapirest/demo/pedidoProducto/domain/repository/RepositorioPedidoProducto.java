package lyjstoreapirest.demo.pedidoProducto.domain.repository;

import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;

import java.util.Optional;

public interface RepositorioPedidoProducto {
    Long guardar(PedidoProducto pedidoProducto);

    Optional<PedidoProducto> buscarPedidoProductoPorId(Long idPedidoProducto);

    Optional<PedidoProducto> eliminarPedidoProductoPorId(Long idPedidoProducto);
}
