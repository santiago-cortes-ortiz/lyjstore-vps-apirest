package lyjstoreapirest.demo.courier.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.service.CourierCrud;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.domain.repository.RepositorioCourier;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class CourierCrudImpl implements CourierCrud {

    private RepositorioCourier repositorioCourier;

    @Override
    public Long guardar(Courier courier) {
        Long courierAGuardar = repositorioCourier.guardar(courier);
        return courierAGuardar;
    }

    @Override
    public Optional<Courier> buscarCourierPorId(Long idCourier) {
        return repositorioCourier.buscarCourierPorId(idCourier);
    }

    @Override
    public Optional<Courier> eliminarCourierPorId(Long idCourier) {
        return repositorioCourier.eliminarCourierPorId(idCourier);
    }

    @Override
    public List<Courier> listarCouriers() {
        return repositorioCourier.listarCouriers();
    }
}
