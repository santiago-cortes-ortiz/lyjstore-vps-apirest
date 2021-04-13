package lyjstoreapirest.demo.pedidoProducto.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Servicio;
import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;
import lyjstoreapirest.demo.pedidoProducto.domain.repository.RepositorioPedidoProducto;
import lyjstoreapirest.demo.pedidoProducto.domain.service.PedidoProductoCrud;

import java.util.Optional;

@Servicio
@AllArgsConstructor
public class PedidoProductoCrudImpl implements PedidoProductoCrud {

    private RepositorioPedidoProducto repositorioPedidoProducto;

    @Override
    public Long guardar(PedidoProducto pedidoProducto) {
        return repositorioPedidoProducto.guardar(pedidoProducto);
    }

    @Override
    public Optional<PedidoProducto> buscarPedidoProductoPorId(Long idPedidoProducto) {
        return repositorioPedidoProducto.buscarPedidoProductoPorId(idPedidoProducto);
    }

    @Override
    public Optional<PedidoProducto> eliminarPedidoProductoPorId(Long idPedidoProducto) {
        return repositorioPedidoProducto.eliminarPedidoProductoPorId(idPedidoProducto);
    }
}
