package lyjstoreapirest.demo.courier.domain.service;

import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;

import java.util.List;
import java.util.Optional;

public interface CourierCrud {

    Long guardar(CourierDTO courier);

    Optional<CourierDTO> buscarCourierPorId(Long idCourier);

    Optional<CourierDTO> eliminarCourierPorId(Long idCourier);

    List<CourierDTO> listarCouriers();

    void actualizarCourier(CourierDTO courierDTO, Long id);

}
