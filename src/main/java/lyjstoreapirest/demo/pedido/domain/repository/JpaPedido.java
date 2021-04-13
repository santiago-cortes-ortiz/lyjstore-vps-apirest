package lyjstoreapirest.demo.pedido.domain.repository;

import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedido extends JpaRepository<Pedido,Long> {
}
