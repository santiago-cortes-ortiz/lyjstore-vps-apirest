package lyjstoreapirest.demo.pedido.domain.repository;

import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedido extends JpaRepository<Pedido,Long> {

}
