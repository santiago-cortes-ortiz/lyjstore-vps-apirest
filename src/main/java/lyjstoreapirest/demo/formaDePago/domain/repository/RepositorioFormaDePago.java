package lyjstoreapirest.demo.formaDePago.domain.repository;

import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;

import java.util.List;
import java.util.Optional;

public interface RepositorioFormaDePago
{
    Long guardar(FormaDePago formaDePago);

    Optional<FormaDePago> buscarFormaDePagoPorId(Long idFormaDePago);

    Optional<FormaDePago> eliminarFormaDePagoPorId(Long idFormaDePago);

    List<FormaDePago> listarFormasDePago();

}
