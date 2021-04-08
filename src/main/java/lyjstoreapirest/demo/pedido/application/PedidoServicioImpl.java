package lyjstoreapirest.demo.pedido.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.pedido.domain.service.PedidoServicio;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import lyjstoreapirest.demo.pedido.domain.repository.RepositorioPedido;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class PedidoServicioImpl implements PedidoServicio {

    private RepositorioPedido repositorioPedido;

    @Override
    public Long guardar(Pedido pedido) {
        return repositorioPedido.save(pedido).getIdPedido();
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long idPedido) {
        return repositorioPedido.findById(idPedido);
    }

    @Override
    public Optional<Pedido> eliminarPedidoPorId(Long idPedido) {
        repositorioPedido.deleteById(idPedido);
        return Optional.empty();
    }

    @Override
    public List<Pedido> listarPedidos() {
        return repositorioPedido.findAll();
    }

}
