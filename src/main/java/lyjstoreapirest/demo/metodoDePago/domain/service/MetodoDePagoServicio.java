package lyjstoreapirest.demo.metodoDePago.domain.service;

import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface MetodoDePagoServicio {

    Long guardar(MetodoPago metodoPago);

    Optional<MetodoPago> buscarMetodoPagoPorId(Long idMetodoPago);

    Optional<MetodoPago> eliminarMetodoPagoPorId(Long idMetodoPago);

    List<MetodoPago> listarMetodosPago();

}
