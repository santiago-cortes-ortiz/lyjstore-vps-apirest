package lyjstoreapirest.demo.courier.domain.repository;

import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;

import java.util.List;
import java.util.Optional;

public interface RepositorioCourier{
    Long guardar(CourierDTO courier);

    CourierDTO buscarCourierPorId(Long idCourier);

    Optional<CourierDTO> eliminarCourierPorId(Long idCourier);

    List<CourierDTO> listarCouriers();
}
