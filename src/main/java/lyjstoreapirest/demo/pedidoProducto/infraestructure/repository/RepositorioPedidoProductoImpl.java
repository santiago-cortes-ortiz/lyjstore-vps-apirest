package lyjstoreapirest.demo.pedidoProducto.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.pedidoProducto.domain.PedidoProducto;
import lyjstoreapirest.demo.pedidoProducto.domain.repository.JpaMetodosPedidoProducto;
import lyjstoreapirest.demo.pedidoProducto.domain.repository.RepositorioPedidoProducto;

import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioPedidoProductoImpl implements RepositorioPedidoProducto {

    private JpaMetodosPedidoProducto jpaMetodosPedidoProducto;

    @Override
    public Long guardar(PedidoProducto pedidoProducto) {

        return null;
    }

    @Override
    public Optional<PedidoProducto> buscarPedidoProductoPorId(Long idPedidoProducto) {
        return Optional.empty();
    }

    @Override
    public Optional<PedidoProducto> eliminarPedidoProductoPorId(Long idPedidoProducto) {
        return Optional.empty();
    }
}
