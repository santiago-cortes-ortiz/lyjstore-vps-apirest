package lyjstoreapirest.demo.cuentaAmazon.domain.repository;

import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;

import java.util.List;
import java.util.Optional;

public interface RepositorioCuentaAmazon {

    Long guardar(CuentaAmazon cuentaAmazon);

    Optional<CuentaAmazon> buscarCuentaAmazonPorId(Long idCuentaAmazon);

    Optional<CuentaAmazon> eliminarCuentaAmazonPorId(Long idCuentaAmazon);

    List<CuentaAmazon> listarCuentasAmazon();
}
