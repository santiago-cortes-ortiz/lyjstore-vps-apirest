package lyjstoreapirest.demo.tiposDeCuenta.application;

import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;

import java.util.List;
import java.util.Optional;

public interface TiposDeCuentaServicio {
    Long guardar(TipoDeCuenta tipoDeCuenta);

    Optional<TipoDeCuenta> buscarTiposDeCuentaPorId(Long idTiposDeCuenta);

    Optional<TipoDeCuenta> eliminarTiposDeCuentaPorId(Long idTiposDeCuenta);

    List<TipoDeCuenta> listarTiposDeCuenta();
}
