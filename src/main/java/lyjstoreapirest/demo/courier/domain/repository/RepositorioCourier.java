package lyjstoreapirest.demo.courier.domain.repository;

import lyjstoreapirest.demo.courier.domain.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioCourier{
    Long guardar(Courier courier);

    Optional<Courier> buscarCourierPorId(Long idCourier);

    Optional<Courier> eliminarCourierPorId(Long idCourier);

    List<Courier> listarCouriers();
}
