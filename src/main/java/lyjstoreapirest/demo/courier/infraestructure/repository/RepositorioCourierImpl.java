package lyjstoreapirest.demo.courier.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.domain.repository.JpaMetodosCourier;
import lyjstoreapirest.demo.courier.domain.repository.RepositorioCourier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RepositorioCourierImpl implements RepositorioCourier {

    private JpaMetodosCourier jpaMetodosCourier;

    @Override
    public Long guardar(Courier courier) {
        return jpaMetodosCourier.save(courier).getId();
    }

    @Override
    public Optional<Courier> buscarCourierPorId(Long idCourier) {
        return jpaMetodosCourier.findById(idCourier);
    }

    @Override
    public Optional<Courier> eliminarCourierPorId(Long idCourier) {
        jpaMetodosCourier.deleteById(idCourier);
        return Optional.empty();
    }

    @Override
    public List<Courier> listarCouriers() {
        return jpaMetodosCourier.findAll();
    }
}
