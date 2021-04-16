package lyjstoreapirest.demo.pedidoProducto.domain.service;

import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;

import java.util.Optional;

public interface PedidoProductoCrud {

    Long guardar(PedidoProducto pedidoProducto);

    Optional<PedidoProducto> buscarPedidoProductoPorId(Long idPedidoProducto);

    Optional<PedidoProducto> eliminarPedidoProductoPorId(Long idPedidoProducto);

}
