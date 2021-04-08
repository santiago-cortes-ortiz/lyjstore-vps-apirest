package lyjstoreapirest.demo.courier.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.service.CourierServicio;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.domain.repository.RepositorioCourier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourierServicioImpl implements CourierServicio {

    private RepositorioCourier repositorioCourier;

    @Override
    public Long guardar(Courier courier) {
        Courier courierAGuardar = repositorioCourier.save(courier);
        return courierAGuardar.getId();
    }

    @Override
    public Optional<Courier> buscarCourierPorId(Long idCourier) {
        return repositorioCourier.findById(idCourier);
    }

    @Override
    public Optional<Courier> eliminarCourierPorId(Long idCourier) {
        repositorioCourier.deleteById(idCourier);
        return Optional.empty();
    }

    @Override
    public List<Courier> listarCouriers() {
        return repositorioCourier.findAll();
    }
}
