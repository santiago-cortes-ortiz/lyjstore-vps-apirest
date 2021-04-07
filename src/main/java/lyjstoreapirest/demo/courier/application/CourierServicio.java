package lyjstoreapirest.demo.courier.application;

import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.courier.domain.model.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierServicio {

    Long guardar(Courier courier);

    Optional<Courier> buscarCourierPorId(Long idCourier);

    Optional<Courier> eliminarCourierPorId(Long idCourier);

    List<Courier> listarCouriers();

}
