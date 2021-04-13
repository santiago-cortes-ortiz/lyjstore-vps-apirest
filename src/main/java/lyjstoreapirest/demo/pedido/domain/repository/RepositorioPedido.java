package lyjstoreapirest.demo.pedido.domain.repository;

import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioPedido
{
    Long guardar(Pedido pedido);

    Optional<Pedido> buscarPedidoPorId(Long idPedido);

    Optional<Pedido> eliminarPedidoPorId(Long idPedido);

    List<Pedido> listarPedidos( );


}
