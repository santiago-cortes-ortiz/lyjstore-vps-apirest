package lyjstoreapirest.demo.formaDePago.domain.service;

import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;

import java.util.List;
import java.util.Optional;

public interface FormaDePagoServicio
{
    Long guardar(FormaDePago formaDePago);

    Optional<FormaDePago> buscarFormaDePagoPorId(Long idFormaDePago);

    Optional<FormaDePago> eliminarFormaDePagoPorId(Long idFormaDePago);

    List<FormaDePago> listarFormasDePago();
}
