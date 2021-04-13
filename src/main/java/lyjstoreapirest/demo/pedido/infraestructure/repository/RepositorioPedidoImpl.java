package lyjstoreapirest.demo.pedido.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import lyjstoreapirest.demo.pedido.domain.repository.JpaPedido;
import lyjstoreapirest.demo.pedido.domain.repository.RepositorioPedido;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioPedidoImpl implements RepositorioPedido
{
    private JpaPedido jpaPedido;


    @Override
    public Long guardar(Pedido pedido) {
        return jpaPedido.save(pedido).getIdPedido();
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long idPedido)
    {
        return jpaPedido.findById(idPedido);
    }

    @Override
    public Optional<Pedido> eliminarPedidoPorId(Long idPedido)
    {
        jpaPedido.deleteById(idPedido);
        return Optional.empty();
    }

    @Override
    public List<Pedido> listarPedidos() {
        return jpaPedido.findAll();
    }
}
