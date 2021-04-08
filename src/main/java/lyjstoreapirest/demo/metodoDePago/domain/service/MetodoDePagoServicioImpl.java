package lyjstoreapirest.demo.metodoDePago.domain.service;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.metodoDePago.application.MetodoDePagoServicio;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;
import lyjstoreapirest.demo.metodoDePago.domain.repository.RepositorioMetodoDePago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MetodoDePagoServicioImpl implements MetodoDePagoServicio {

    private RepositorioMetodoDePago repositorioMetodoDePago;

    @Override
    public Long guardar(MetodoPago metodoPago) {
        return repositorioMetodoDePago.save(metodoPago).getIdTarjeta();
    }

    @Override
    public Optional<MetodoPago> buscarMetodoPagoPorId(Long idMetodoPago) {
        return repositorioMetodoDePago.findById(idMetodoPago);
    }

    @Override
    public Optional<MetodoPago> eliminarMetodoPagoPorId(Long idMetodoPago) {
        repositorioMetodoDePago.deleteById(idMetodoPago);
        return Optional.empty();
    }

    @Override
    public List<MetodoPago> listarMetodosPago() {
        return repositorioMetodoDePago.findAll();
    }

}
