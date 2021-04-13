package lyjstoreapirest.demo.pedido.domain.service;

import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoServicio
{

    Long guardar(Pedido pedido);

    Optional<Pedido> buscarPedidoPorId(Long idPedido);

    Optional<Pedido> eliminarPedidoPorId(Long idPedido);

    List<Pedido> listarPedidos();

}
