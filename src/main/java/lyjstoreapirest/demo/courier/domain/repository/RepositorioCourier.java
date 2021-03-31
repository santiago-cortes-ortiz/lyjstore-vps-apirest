package lyjstoreapirest.demo.courier.domain.repository;

import lyjstoreapirest.demo.courier.domain.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCourier extends JpaRepository<Courier,Long> {
}
