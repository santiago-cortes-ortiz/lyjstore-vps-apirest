package lyjstoreapirest.demo.metodoDePago.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;
import lyjstoreapirest.demo.metodoDePago.domain.repository.JpaMetodosMetodoDePago;
import lyjstoreapirest.demo.metodoDePago.domain.repository.RepositorioMetodoDePago;

import java.util.List;
import java.util.Optional;


@Repositorio
@AllArgsConstructor
public class RepositorioMetodoDePagoImpl implements RepositorioMetodoDePago {

    private JpaMetodosMetodoDePago jpaMetodosMetodoDePago;

    @Override
    public Long guardar(MetodoPago metodoPago) {
        return jpaMetodosMetodoDePago.save(metodoPago).getIdTarjeta();
    }

    @Override
    public Optional<MetodoPago> buscarMetodoPagoPorId(Long idMetodoPago) {
        return jpaMetodosMetodoDePago.findById(idMetodoPago);
    }

    @Override
    public Optional<MetodoPago> eliminarMetodoPagoPorId(Long idMetodoPago) {
        jpaMetodosMetodoDePago.deleteById(idMetodoPago);
        return Optional.empty();
    }

    @Override
    public List<MetodoPago> listarMetodosPago() {
        return jpaMetodosMetodoDePago.findAll();
    }
}
