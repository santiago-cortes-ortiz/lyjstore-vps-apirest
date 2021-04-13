package lyjstoreapirest.demo.metodoDePago.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.metodoDePago.domain.service.MetodoDePagoServicio;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;
import lyjstoreapirest.demo.metodoDePago.domain.repository.RepositorioMetodoDePago;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class MetodoDePagoServicioImpl implements MetodoDePagoServicio {

    private RepositorioMetodoDePago repositorioMetodoDePago;

    @Override
    public Long guardar(MetodoPago metodoPago) {
        return repositorioMetodoDePago.guardar(metodoPago);

    }

    @Override
    public Optional<MetodoPago> buscarMetodoPagoPorId(Long idMetodoPago) {
        return repositorioMetodoDePago.buscarMetodoPagoPorId(idMetodoPago);
    }

    @Override
    public Optional<MetodoPago> eliminarMetodoPagoPorId(Long idMetodoPago) {
        repositorioMetodoDePago.eliminarMetodoPagoPorId(idMetodoPago);
        return Optional.empty();
    }

    @Override
    public List<MetodoPago> listarMetodosPago() {
        return repositorioMetodoDePago.listarMetodosPago();
    }

}
