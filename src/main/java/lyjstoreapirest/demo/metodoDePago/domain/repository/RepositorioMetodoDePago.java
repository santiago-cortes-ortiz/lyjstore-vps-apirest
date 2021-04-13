package lyjstoreapirest.demo.metodoDePago.domain.repository;

import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioMetodoDePago  {

    Long guardar(MetodoPago metodoPago);

    Optional<MetodoPago> buscarMetodoPagoPorId(Long idMetodoPago);

    Optional<MetodoPago> eliminarMetodoPagoPorId(Long idMetodoPago);

    List<MetodoPago> listarMetodosPago();

}
