package lyjstoreapirest.demo.cuentaAmazon.application;

import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;

import java.util.List;
import java.util.Optional;

public interface CuentaAmazonServicio {
    Long guardar(CuentaAmazon cuentaAmazon);

    Optional<CuentaAmazon> buscarCuentaAmazonPorId(Long idCuentaAmazon);

    Optional<CuentaAmazon> eliminarCuentaAmazonPorId(Long idCuentaAmazon);

    List<CuentaAmazon> listarCuentasAmazon();
}
